package com.istad.springthymleafpartone.service.serviceImpl;

import com.istad.springthymleafpartone.model.Article;
import com.istad.springthymleafpartone.repository.ArticleRepository;
import com.istad.springthymleafpartone.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    // need to call repository
    ArticleRepository articleRepository;
    ArticleServiceImpl(){
        articleRepository = new ArticleRepository();
    }
    @Override
    public List<Article> getAllArticle() {
        return articleRepository.getAllArticle();
    }

    @Override
    public Article getArticleByID(int id) {
        return articleRepository.getArticleByID(id);
    }

    @Override
    public void addNewArticle(Article article) {
        articleRepository.addNewArticle(article);

    }
}
