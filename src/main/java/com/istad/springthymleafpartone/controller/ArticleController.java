package com.istad.springthymleafpartone.controller;

import com.istad.springthymleafpartone.model.Article;
import com.istad.springthymleafpartone.model.Author;
import com.istad.springthymleafpartone.model.request.ArticleRequest;
import com.istad.springthymleafpartone.service.ArticleService;
import com.istad.springthymleafpartone.service.AuthorService;
import com.istad.springthymleafpartone.service.FileUploadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class ArticleController {

    // 3
    // 1. Constructor injection
    // 2. Field injection
    // 3. Setter Injection


    ArticleService articleService;
    FileUploadService fileUploadService;

    AuthorService authorService;


    @Autowired
    ArticleController(ArticleService articleService
            , AuthorService authorService,
                      FileUploadService fileUploadService) {
        this.articleService = articleService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
    }


    @GetMapping("/all-articles")
    public String getAllArticle(Model model ) {
        model.addAttribute("allArticles",
                articleService.getAllArticle());
        return "all-article";
    }

    @GetMapping("/post/{postID}")
    public String getPostByID(@PathVariable int postID, Model model) {
        model.addAttribute("article", articleService.getArticleByID(postID));
        return "viewArticle";

    }

    @GetMapping("/form-add-article")
    public String getFormAdd(Model model) {
        model.addAttribute("article", new ArticleRequest());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "new-article";
    }

    @PostMapping("/handleAddArticle")
    public String handleAddArticle(@Valid @ModelAttribute("article")  ArticleRequest article, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            System.out.println("Erorr has happened!!!");
//            model.addAttribute("article", new ArticleRequest());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "new-article";
        }
        Article newArticle = new Article();
        try{
            String filenames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(article.getFile());

            newArticle.setImgUrl(filenames);
        }catch (Exception ex){
            newArticle.setImgUrl("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error : "+ex.getMessage());
        }

        // mapstruct vs model mapper
        newArticle.setTitle(article.getTitle());
        newArticle.setDescription(article.getDescription());
//        newArticle.setImgUrl(article.getImgUrl());

        // find the article by ID
        newArticle.setAuthor(authorService.getAllAuthors().stream().filter(e -> e.getId() == article.getAuthorID())
                .findFirst().orElse(null));

        // id , author
        // get the max article id and add the value by 1
        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);

           articleService.addNewArticle(newArticle);
        return "redirect:/all-articles";
    }


}
