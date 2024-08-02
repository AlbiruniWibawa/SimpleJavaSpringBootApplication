package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllItems() {
        return orderService.findAllOrders();
    }

    @PostMapping("/new")
    public Order createOrder(@RequestBody OrderRequest request) {
        
        return orderService.createOrder(request);
    }
    

}
