package com.example.study.controller.Item;


import com.example.study.entity.Item;
import com.example.study.model.AddAuctionInput;
import com.example.study.repository.BookRepository;
import com.example.study.repository.ItemRepository;
import com.example.study.service.AuctionService;
import jakarta.validation.Valid;
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
    private ItemRepository itemRepository;
    private AuctionService auctionService;

    ItemController(AuctionService auctionService,ItemRepository itemRepository){
        this.auctionService=auctionService;
        this.itemRepository=itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getAllBooks() {
        List<Item> books = itemRepository.findAll();
        return books;
    }
//
//    @PostMapping
//    public ResponseEntity<Item> addItem(@RequestBody Item item) {
//        Item savedItem = ItemRepository.save(item);
//        return ResponseEntity.ok(savedItem);
//    }


    @PostMapping("/auction")
    public long addBook(@RequestBody @Valid AddAuctionInput inPut){
        long id=auctionService.addItem(inPut);
        return id;
    }
}
