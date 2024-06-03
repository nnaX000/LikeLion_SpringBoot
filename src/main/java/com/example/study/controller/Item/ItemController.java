package com.example.study.controller.Item;


import com.example.study.entity.Item;
import com.example.study.model.AddAuctionInput;
import com.example.study.model.ItemUpdateDTO;
import com.example.study.repository.BookRepository;
import com.example.study.repository.ItemRepository;
import com.example.study.service.AuctionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/items/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable Long itemId, @RequestBody ItemUpdateDTO itemUpdateDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (item.getStartingPrice() < itemUpdateDTO.getStartingPrice()) {
            item.setStartingPrice(itemUpdateDTO.getStartingPrice());
            item.setDescription(itemUpdateDTO.getDescription());
            itemRepository.save(item);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.badRequest().body("새로운 가격은 기존 가격보다 높아야 합니다.");
        }
    }
}
