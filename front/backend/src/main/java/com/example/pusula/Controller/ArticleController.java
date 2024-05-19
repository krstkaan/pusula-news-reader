package com.example.pusula.Controller;


import com.example.pusula.Service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ArticleController {

    private ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
    @GetMapping("/articles")
    public String news(Model model) {

        return "articles";

    }
    @GetMapping("/privateArticle")
    public String privateNews(Model model) {

        return "p_articles";

    }
}
