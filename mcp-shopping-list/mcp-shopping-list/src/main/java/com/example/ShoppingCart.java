package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCart {
    public record ShoppingItem(String name, int quantity){

    }

    private final Map<String, ShoppingItem> shoppinglist = new ConcurrentHashMap<>();

    @Tool(name="addItem", description= "Add an item to the shopping list or update its quantity, specify quantity.")
    public String addItem(String name, int quantity){
        if(name == null || name.trim().isEmpty() || quantity <=0){
            return "Error: Invalid item name or quantity";
        }
        shoppinglist.compute(name.toLowerCase(), (key, existingItem) -> {
            if(existingItem == null){
                return new ShoppingItem(name, quantity);
            } else{
                return new ShoppingItem(existingItem.name(), existingItem.quantity());
            }
        )}
    }
}
