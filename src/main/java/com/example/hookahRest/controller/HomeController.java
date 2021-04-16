package com.example.hookahRest.controller;

import com.example.hookahRest.model.AdminPage;
import com.example.hookahRest.model.Event;
import com.example.hookahRest.model.TableInfo;
import com.example.hookahRest.model.Сompetition;
import com.example.hookahRest.service.IService.IEventService;
import com.example.hookahRest.service.IService.ITableService;
import com.example.hookahRest.service.IService.IСompetitionService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000", "https://cosanostralounge.ru", "http://45.67.59.183:3000"})
@RestController
@RequestMapping("api/")
public class HomeController {

    private IСompetitionService iСompetitionService;
    private ITableService iTableService;
    private IEventService iEventService;

    public HomeController(IСompetitionService iСompetitionService, ITableService iTableService, IEventService iEventService) {
        this.iСompetitionService = iСompetitionService;
        this.iTableService = iTableService;
        this.iEventService = iEventService;
    }

    //login

    @PostMapping("login")
    public String login(@RequestBody AdminPage adminPage) {
        byte[] encodedBytes = Base64.encodeBase64((adminPage.getLogin() + ":" + adminPage.getPassword()).getBytes());
        System.out.println(new String(encodedBytes));
        return new String(encodedBytes);
    }

    @PostMapping("login/check")
    public String loginCkeck(@RequestBody Object adminPage) {
        return "true";
    }


    //table

    @GetMapping("table/info")
    public Iterable getTableInfo() {
        return this.iTableService.getTableInfo();
    }

    @PostMapping("table/create")
    public void createTable(@RequestBody TableInfo booking) {
        iTableService.createTable(booking);
    }

    @PutMapping("table/update/{id}")
    public void updateTable(@PathVariable Long id, @RequestBody TableInfo booking) {
        iTableService.updateTable(id, booking);
    }

    @DeleteMapping("table/delete/{id}")
    public void deleteTable(@PathVariable Long id) {
        iTableService.deleteTable(id);
    }

    //event

    @GetMapping("event/info")
    public Iterable getEventInfo() {
        return this.iEventService.getEventInfo();
    }

    @PostMapping("event/create")
    public void createEvent(@RequestBody Event booking) {
        this.iEventService.createEvent(booking);
    }

    @PutMapping("event/update/{id}")
    public void updateEvent(@PathVariable Long id, @RequestBody Event booking) {
        this.iEventService.updateEvent(id, booking);
    }

    @DeleteMapping("event/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        this.iEventService.deleteEvent(id);
    }

    //competition

    @GetMapping("competition/info")
    public Iterable getСompetitionInfo() {
        return this.iСompetitionService.getСompetitionInfo();
    }

    @PostMapping("competition/create")
    public void createСompetition(@RequestBody Сompetition booking) {
        this.iСompetitionService.createСompetition(booking);
    }

    @PutMapping("competition/update/{id}")
    public void updateСompetition(@PathVariable Long id, @RequestBody Сompetition booking) {
        this.iСompetitionService.updateСompetition(id, booking);
    }

    @DeleteMapping("competition/delete/{id}")
    public void deleteСompetition(@PathVariable Long id) {
        this.iСompetitionService.deleteСompetition(id);
    }

}
