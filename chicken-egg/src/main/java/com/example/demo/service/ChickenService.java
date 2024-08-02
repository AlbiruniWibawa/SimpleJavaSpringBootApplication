package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ChickenRequest;
import com.example.demo.model.Chicken;
import com.example.demo.repository.ChickenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChickenService {
    
    private final ChickenRepository chickenRepository;

    public List<Chicken> getAllChickens() {
        return chickenRepository.getAllChickens();
    }

    public Chicken addChicken(ChickenRequest request) {

        Chicken chicken = new Chicken();
        chicken.setId(Long.valueOf(chickenRepository.getAllChickens().size()));
        chicken.setEggs(request.getEggs());
        chicken.setPricePerEggs(request.getPrice());

        return chickenRepository.addChicken(chicken);
    }

}
