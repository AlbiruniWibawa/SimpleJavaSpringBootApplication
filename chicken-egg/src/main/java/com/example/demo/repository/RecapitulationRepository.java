package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Recapitulation;

@Repository
public class RecapitulationRepository {
    
    List<Recapitulation> recapitulationList = new ArrayList<>();

    public List<Recapitulation> getAllRecapitulations() {
        return recapitulationList;
    }

    public Recapitulation addRecapitulation(Recapitulation recapitulation) {
        recapitulationList.add(recapitulation);

        return recapitulation; 
    }

}
