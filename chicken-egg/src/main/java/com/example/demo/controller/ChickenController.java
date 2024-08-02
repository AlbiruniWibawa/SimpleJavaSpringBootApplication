package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChickenRequest;
import com.example.demo.model.Chicken;
import com.example.demo.service.ChickenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chickens")
public class ChickenController {
    
    private final ChickenService chickenService;

    @GetMapping("/all")
    public List<Chicken> getAllChickens() {
        return chickenService.getAllChickens();
    }

    @PostMapping("/add-eggs")
    public Chicken addChickens(@RequestBody ChickenRequest request) {
        return chickenService.addChicken(request);
    }

}
