package com.istad.springthymleafpartone.model.request;

import com.istad.springthymleafpartone.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

    private String title;
    private String description;
    private String imgUrl;
    private int authorID;
}
