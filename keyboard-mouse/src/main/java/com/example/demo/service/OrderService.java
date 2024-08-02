package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public Order createOrder(OrderRequest request) {
        List<Item> mouses = itemRepository.findAllItems().stream().filter(i -> i.getName().toLowerCase().contains("mouse")).toList();
        List<Item> keyboards = itemRepository.findAllItems().stream().filter(i -> i.getName().toLowerCase().contains("keyboard")).toList();

        Double bestTotal = 0.0;
        List<String> itemsName = new ArrayList<>();
        String mouseName = null;
        String keyboardName = null;
        
        for (Item keyboard : keyboards) {
            for (Item mouse : mouses) {
                Double currentTotal = keyboard.getPrice() + mouse.getPrice();
                
                if (currentTotal <= request.getPriceOrder() && currentTotal > bestTotal) {
                    bestTotal = currentTotal;
                    mouseName = mouse.getName();
                    keyboardName = keyboard.getName();
                }
            }
        }
        itemsName.add(keyboardName);
        itemsName.add(mouseName);

        Order order = new Order();
        order.setId(Long.valueOf(orderRepository.findAllOrders().size()) + 1);
        order.setItemsName(itemsName);
        order.setPriceOrder(bestTotal);
        order.setOrderDate(Date.valueOf(LocalDate.now()));
        
        return orderRepository.saveOrder(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }
}
