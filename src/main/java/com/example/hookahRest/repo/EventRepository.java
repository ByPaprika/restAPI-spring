package com.example.hookahRest.repo;

import com.example.hookahRest.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
