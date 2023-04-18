package com.istad.springthymleafpartone.repository;


import com.istad.springthymleafpartone.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
 private    List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"james","male", "nothing last forever"));
        add(new Author(1002,"buna","male", "nothing last forever"));
        add(new Author(1003,"rithy","male", "nothing last forever"));
        add(new Author(1004,"koko","female", "nothing last forever"));

    }} ;

 public List<Author> getAllAuthor(){
     return authors;
 }
 // create
    // update
    // delete
    // search ....
}
