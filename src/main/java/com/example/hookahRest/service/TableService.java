package com.example.hookahRest.service;

import com.example.hookahRest.model.TableInfo;
import com.example.hookahRest.repo.TableInfoRepository;
import com.example.hookahRest.service.IService.ITableService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class TableService implements ITableService {
    private TableInfoRepository tableInfoRepository;

    public TableService(TableInfoRepository tableInfoRepository) {
        this.tableInfoRepository = tableInfoRepository;
    }

    @Override
    public Iterable getTableInfo() {
        return this.tableInfoRepository.findAll();
    }

    @Override
    public void createTable(TableInfo booking) {
        this.tableInfoRepository.save(booking);
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "1593929800:AAEbVK1ppprVjXJMeH7eKjSQejpOcY5MD8g";
        String chatId = "455126766";
        String text = booking.toString();
        urlString = String.format(urlString, apiToken, chatId, text);
        URL url = null;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();StringBuilder sb = new StringBuilder();
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            String response = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTable(Long id, TableInfo booking) {
        TableInfo tableInfo = null;
        try {
            tableInfo = this.tableInfoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableInfo.setName(booking.getName());
        tableInfo.setPhone(booking.getPhone());
        tableInfo.setDescription(booking.getDescription());
        tableInfo.setCount(booking.getCount());
        tableInfo.setData(booking.getData());
        tableInfo.setTime(booking.getTime());
        this.tableInfoRepository.save(tableInfo);
    }

    @Override
    public void deleteTable(Long id) {
        TableInfo tableInfo = null;
        try {
            tableInfo = this.tableInfoRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tableInfoRepository.delete(tableInfo);
    }
}
