package com.example.study.controller.Item;


import com.example.study.entity.Item;
import com.example.study.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository ItemRepository;

    @GetMapping("/items")
    public List<Item> getAllBooks() {
        List<Item> books = ItemRepository.findAll();
        return books;
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = ItemRepository.save(item);
        return ResponseEntity.ok(savedItem);
    }
}
