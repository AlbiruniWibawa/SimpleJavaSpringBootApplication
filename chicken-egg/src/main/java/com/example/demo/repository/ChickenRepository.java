package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Chicken;

@Repository
public class ChickenRepository {
    
    List<Chicken> chickenList = new ArrayList<>();

    public List<Chicken> getAllChickens() {
        return chickenList;
    }

    public Chicken addChicken(Chicken chicken) {
        chickenList.add(chicken);

        return chicken;
    }

}
