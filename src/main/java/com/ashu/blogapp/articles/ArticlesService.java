package com.ashu.blogapp.articles;

import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    ArticlesService(ArticlesRepository articlesRepository){
        this.articlesRepository=articlesRepository;
    }
}
