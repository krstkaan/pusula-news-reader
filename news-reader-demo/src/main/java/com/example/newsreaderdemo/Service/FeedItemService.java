package com.example.newsreaderdemo.Service;


import com.example.newsreaderdemo.Entity.FeedItem;
import com.example.newsreaderdemo.Repository.FeedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedItemService {

    private FeedItemRepository feedItemRepository;

    @Autowired
    public FeedItemService(FeedItemRepository feedItemRepository) {
        this.feedItemRepository = feedItemRepository;
    }
    public List<FeedItem> getAll(){
        return feedItemRepository.findAll();
    }
}
