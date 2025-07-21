package com.ashu.blogapp.articles;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.ashu.blogapp.users.UserEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( nullable = false)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String slug;
    @Nullable
    private String subtitle;
    @NonNull
    private String body;

    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="authorId",nullable = false)
    private UserEntity author;
}
