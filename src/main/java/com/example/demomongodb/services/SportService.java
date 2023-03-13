package com.example.demomongodb.services;

import com.example.demomongodb.entities.Sport;
import com.example.demomongodb.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {
    @Autowired
    private SportRepository  sportRepository;

    public Sport saveSport(Sport sport){
        return sportRepository.save(sport);
    }
    public List<Sport> getSports(){
        return sportRepository.findAll();
    }
}
