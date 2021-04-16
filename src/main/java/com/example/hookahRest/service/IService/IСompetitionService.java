package com.example.hookahRest.service.IService;

import com.example.hookahRest.model.Сompetition;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IСompetitionService {

    Iterable getСompetitionInfo();

    void createСompetition(@RequestBody Сompetition booking);

    void updateСompetition(@PathVariable Long id, @RequestBody Сompetition booking);

    void deleteСompetition(@PathVariable Long id);
}
