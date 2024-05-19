package com.example.pusula.Controller;


import com.example.pusula.DTO.ArticleDTO;
import com.example.pusula.DTO.CategoryDTO;
import com.example.pusula.DTO.UserDTO;
import com.example.pusula.Entity.Article;
import com.example.pusula.Entity.Category;
import com.example.pusula.Entity.User;

import com.example.pusula.Service.ArticleService;
import com.example.pusula.Service.CategoryService;
import com.example.pusula.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    private ArticleService articleService;
    private UserService userService;
    private CategoryService categoryService;

    @Autowired
    public HomeController(ArticleService articleService, UserService userService, CategoryService categoryService) {
        this.articleService = articleService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<ArticleDTO> getPublicArticles(){
        return articleService.getAllArticlesPublic();
    }

    @GetMapping("/private")
    public List<ArticleDTO> getPrivateArticles(){
        return articleService.getAllArticlesPrivate();
    }

    @GetMapping("/article/{id}")
    public ArticleDTO getpublicArticleById(@PathVariable int id){
        return articleService.getPublicArticleById(id);
    }
    @GetMapping("/private/{id}")
    public ArticleDTO getPrivateArticles(@PathVariable int id){
        return articleService.getPrivateArticleById(id);
    }

    @PostMapping("/createArticle")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.insertArticle(articleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleDTO);
    }

    @GetMapping("/getCategory/{id}")
    public CategoryDTO getCategory(@PathVariable int id){
        return categoryService.findById(id);
    }
    @GetMapping("/getUser/{id}")
    public UserDTO getUser(@PathVariable int id){
        return userService.findById(id);
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.save(userDTO, 2);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }


    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO, 11);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }


}
