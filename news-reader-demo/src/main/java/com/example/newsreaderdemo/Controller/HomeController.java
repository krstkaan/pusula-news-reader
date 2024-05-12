package com.example.newsreaderdemo.Controller;


import com.example.newsreaderdemo.Service.FeedItemService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    private FeedItemService feedItemService;

    public HomeController(FeedItemService feedItemService) {
        this.feedItemService = feedItemService;
    }
}
