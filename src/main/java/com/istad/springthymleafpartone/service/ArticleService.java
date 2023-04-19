package com.istad.springthymleafpartone.service;

import com.istad.springthymleafpartone.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleByID(int id );

    void addNewArticle(Article article);
}
