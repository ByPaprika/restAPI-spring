package com.example.hookahRest.service.IService;

import com.example.hookahRest.model.Event;

public interface IEventService {
    Iterable getEventInfo();

    void createEvent(Event booking);

    void updateEvent(Long id, Event booking);

    void deleteEvent(Long id);
}
