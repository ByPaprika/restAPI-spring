package com.example.hookahRest.service;

import com.example.hookahRest.model.Сompetition;
import com.example.hookahRest.repo.СompetitionRepositrory;
import com.example.hookahRest.service.IService.IСompetitionService;
import org.springframework.stereotype.Service;

@Service
public class СompetitionService implements IСompetitionService {
    private СompetitionRepositrory competitionRepositrory;

    public СompetitionService(СompetitionRepositrory competitionRepositrory) {
        this.competitionRepositrory = competitionRepositrory;
    }

    @Override
    public Iterable getСompetitionInfo() {
        return this.competitionRepositrory.findAll();
    }

    @Override
    public void createСompetition(Сompetition booking) {
        this.competitionRepositrory.save(booking);
    }

    @Override
    public void updateСompetition(Long id, Сompetition booking) {
        Сompetition competition = null;
        try {
            competition = this.competitionRepositrory.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        competition.setName(booking.getName());
        competition.setPhone(booking.getPhone());
        competition.setPoints(booking.getPoints());
        this.competitionRepositrory.save(competition);
    }

    @Override
    public void deleteСompetition(Long id) {
        Сompetition competition = null;
        try {
            competition = this.competitionRepositrory.findById(id).orElseThrow(() -> new Exception("not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.competitionRepositrory.delete(competition);
    }
}
