package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recapitulation;
import com.example.demo.service.RecapitulationService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/recapitulation")
public class RecapitulationController {
    
    private final RecapitulationService recapitulationService;

    @GetMapping("/calculate")
    public Recapitulation calculate() {
        return recapitulationService.addRecapitulation();
    }
    

}
