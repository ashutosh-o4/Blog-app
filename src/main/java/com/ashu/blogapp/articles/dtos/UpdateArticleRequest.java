package com.ashu.blogapp.articles.dtos;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class UpdateArticleRequest {
    private String title;
    private String body;
    private String subtitle;
}

