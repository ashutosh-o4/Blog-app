package com.ashu.blogapp.comments;

import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    CommentsService(CommentsRepository commentsRepository){

        this.commentsRepository=commentsRepository;
    }
}
