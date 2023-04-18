package com.istad.springthymleafpartone.controller;

import com.istad.springthymleafpartone.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

     ArticleService articleService;
     @Autowired
     ArticleController(ArticleService articleService){
         this.articleService  = articleService;
     }



    @GetMapping("/all-articles")
    public String getAllArticle(Model model){
         model.addAttribute("allArticles",articleService.getAllArticle());
        return "all-article";
    }
}
