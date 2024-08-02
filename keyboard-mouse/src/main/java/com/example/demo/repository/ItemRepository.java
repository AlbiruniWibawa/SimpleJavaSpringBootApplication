package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Item;

@Repository
public class ItemRepository {
    
    private List<Item> ItemList = new ArrayList<>();
    
    public List<Item> findAllItems() {

        if (ItemList.isEmpty()) {
            Item mouse1 = new Item();
            mouse1.setName("Mouse 1");
            mouse1.setPrice(12000.0);

            Item mouse2 = new Item();
            mouse2.setName("Mouse 2");
            mouse2.setPrice(20000.0);

            Item mouse3 = new Item();
            mouse3.setName("Mouse 3");
            mouse3.setPrice(35000.0);

            ItemList.add(mouse1);
            ItemList.add(mouse2);
            ItemList.add(mouse3);

            Item keyboard1 = new Item();
            keyboard1.setName("Keyboard 1");
            keyboard1.setPrice(12000.0);

            Item keyboard2 = new Item();
            keyboard2.setName("Keyboard 2");
            keyboard2.setPrice(20000.0);

            Item keyboard3 = new Item();
            keyboard3.setName("Keyboard 3");
            keyboard3.setPrice(35000.0);

            ItemList.add(keyboard1);
            ItemList.add(keyboard2);
            ItemList.add(keyboard3);
        }

        return ItemList;
    }

}
