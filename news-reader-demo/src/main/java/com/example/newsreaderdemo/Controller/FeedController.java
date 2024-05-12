package com.example.newsreaderdemo.Controller;


import com.example.newsreaderdemo.Entity.FeedItem;
import com.example.newsreaderdemo.Service.FeedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedController {

    private FeedItemService feedItemService;

    @Autowired
    public FeedController(FeedItemService feedItemService) {
        this.feedItemService = feedItemService;
    }

    @GetMapping("/feed")
    public List<FeedItem> getFeed(){
        return feedItemService.getAll();
    }
}
