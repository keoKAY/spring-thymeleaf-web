package com.istad.springthymleafpartone.repository;

import com.istad.springthymleafpartone.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{

        add(new Article(1001,"ChatGPT ", " new evolution of prompt programming ","something.jpg",new AuthorRepository().getAllAuthor().get(0)));

        add(new Article(1002,"java Programming ", " java programming is about about oop ","something.jpg",new AuthorRepository().getAllAuthor().get(2)));

        add(new Article(1003,"Football in Cambodia ", " Football is a popular sport in cambodia now","something.jpg",new AuthorRepository().getAllAuthor().get(3)));

    }} ;


    public List<Article> getAllArticle(){
        return articleList;
    }

    public Article getArticleByID(int id ){
        return articleList.stream().filter(e-> e.getId()==id).findFirst()
                .orElse(null);
    }


}
