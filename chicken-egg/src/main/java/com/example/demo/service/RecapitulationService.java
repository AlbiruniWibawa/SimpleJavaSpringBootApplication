package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Chicken;
import com.example.demo.model.Recapitulation;
import com.example.demo.repository.RecapitulationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecapitulationService {
    
    private final ChickenService chickenService;
    private final RecapitulationRepository recapRepository;

    public Recapitulation addRecapitulation() {

        List<Chicken> chickens = chickenService.getAllChickens();
        Integer totalPrice = 0;
        for (Chicken chicken : chickens) {
            totalPrice += (int) (chicken.getEggs() * chicken.getPricePerEggs());
        }
        Recapitulation recap = new Recapitulation();
        recap.setId(Long.valueOf(recapRepository.getAllRecapitulations().size()));
        recap.setChickens(chickens);
        recap.setTotalPrice(totalPrice);
        return recapRepository.addRecapitulation(recap);
    }

}
