package com.istad.springthymleafpartone.model.request;

import com.istad.springthymleafpartone.model.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

    @NotEmpty(message = "Title cannot be empty !")
    private String title;
    @NotEmpty(message="Description cannot be empty!")
    private String description;
    private String imgUrl;
   // @Pattern(regexp ="\\d+", message = " AuthorID can only be number ")
    private int authorID;
}
