package com.example.hookahRest.service;

import com.example.hookahRest.model.Event;
import com.example.hookahRest.repo.EventRepository;
import com.example.hookahRest.service.IService.IEventService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class EventService implements IEventService {

    private EventRepository eventRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public Iterable getEventInfo() {
        return this.eventRepository.findAll();
    }

    @Override
    public void createEvent(Event booking) {
        this.eventRepository.save(booking);
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "1593929800:AAEbVK1ppprVjXJMeH7eKjSQejpOcY5MD8g";
        String chatId = "455126766";
        String text = booking.toString();
        urlString = String.format(urlString, apiToken, chatId, text);
        URL url = null;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            StringBuilder sb = new StringBuilder();
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
    public void updateEvent(Long id, Event booking) {
        Event event = null;
        try {
            event = this.eventRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        event.setName(booking.getName());
        event.setPhone(booking.getPhone());
        event.setDescription(booking.getDescription());
        event.setEmail(booking.getEmail());
        this.eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = null;
        try {
            event = this.eventRepository.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.eventRepository.delete(event);
    }
}
