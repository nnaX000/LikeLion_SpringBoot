package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.entity.Item;
import com.example.study.model.AddAuctionInput;
import com.example.study.model.AddBookInPut;
import com.example.study.repository.BookRepository;
import com.example.study.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {
    private ItemRepository itemRepository;
    public AuctionService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }
    public long addItem(AddAuctionInput inPut){
        Item item= Item.builder()
                .name(inPut.getName().toString())
                .description(inPut.getDescription().toString())
                .startingPrice(inPut.getStartingPrice())
                .build();
        Item save=itemRepository.save(item);
        return save.getId();
    }
}
