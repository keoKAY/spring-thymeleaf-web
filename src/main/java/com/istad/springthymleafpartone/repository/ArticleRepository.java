package com.istad.springthymleafpartone.repository;

import com.istad.springthymleafpartone.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{

        add(new Article(1001,"ChatGPT ", " new evolution of prompt programming ","https://i.pinimg.com/originals/7e/d8/7c/7ed87ca036e65c8b31d87b38d035db69.jpg",new AuthorRepository().getAllAuthor().get(0)));

        add(new Article(1002,"java Programming ", " java programming is about about oop ","https://i.pinimg.com/736x/ae/76/eb/ae76ebdd53ec35089c934641430a8aa2.jpg",new AuthorRepository().getAllAuthor().get(2)));

        add(new Article(1003,"Football in Cambodia ", " Football is a popular sport in cambodia now","https://i.pinimg.com/originals/a6/4c/ae/a64caebc45c628041b3bf263d82544d9.jpg",new AuthorRepository().getAllAuthor().get(3)));

    }} ;


    public List<Article> getAllArticle(){
        return articleList;
    }

    public Article getArticleByID(int id ){
        return articleList.stream().filter(e-> e.getId()==id).findFirst()
                .orElse(null);
    }

    public void addNewArticle(Article article){
        articleList.add(article);
    }


}
