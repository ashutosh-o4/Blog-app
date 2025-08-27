package com.ashu.blogapp.articles;

import com.ashu.blogapp.users.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping("")
    public String getArticle(){
        return "Get all Article";
    }

    @GetMapping("/{id}")
    String getArticleById(@PathVariable("id") String id){
        return "Get Article by ID:"+id;
    }

    @PostMapping("")
    String createArticles(@AuthenticationPrincipal UserEntity user){
        return "Create Articles called by" + user.getUsername();
    }
}
