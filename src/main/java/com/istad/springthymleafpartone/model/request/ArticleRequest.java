package com.istad.springthymleafpartone.model.request;

import com.istad.springthymleafpartone.model.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

    @NotEmpty(message = "Title cannot be empty !")
    private String title;
    @NotEmpty(message="Description cannot be empty!")
    private String description;

    private MultipartFile file;
   // @Pattern(regexp ="\\d+", message = " AuthorID can only be number ")
    private int authorID;
}
