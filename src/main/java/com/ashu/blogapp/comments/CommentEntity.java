package com.ashu.blogapp.comments;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import com.ashu.blogapp.articles.ArticleEntity;
import com.ashu.blogapp.users.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "comments")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( nullable = false)
    private Long id;

    @Nullable
    private String title;

    @NonNull
    private String body;
    
    @CreatedDate
    private Date createdAt;

     @ManyToOne
    @JoinColumn(name="articleId",nullable = false)
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name="authorId",nullable = false)
    private UserEntity author;

}
