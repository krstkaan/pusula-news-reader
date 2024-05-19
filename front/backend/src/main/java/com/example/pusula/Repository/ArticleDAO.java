package com.example.pusula.Repository;

import com.example.pusula.Entity.Article;

import java.util.List;

public interface ArticleDAO {
    List<Article> getAllArticlesPublic();
    List<Article> getSports();
    List<Article> getPolitics();
    List<Article> getHealth();
    List<Article> getTechnology();
    List<Article> getAllArticlesPrivate();
    Article getPublicArticleById(int id);
    Article getPrivateArticleById(int id);
    void insertArticle(Article article);
    void deleteArticle(int id);

}
