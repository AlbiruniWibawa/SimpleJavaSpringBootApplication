package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;

@Repository
public class OrderRepository {
    
    private List<Order> orderList = new ArrayList<>();

    public List<Order> findAllOrders() {
        return orderList;
    }

    public Order saveOrder(Order order) {
        orderList.add(order);

        return order;
    }

}
