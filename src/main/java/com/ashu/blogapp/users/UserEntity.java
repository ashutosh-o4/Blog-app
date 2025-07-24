package com.ashu.blogapp.users;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( nullable = false)
    private Long id;
    @Column( nullable = false)
    @NonNull
    private String username;
    @Column( nullable = false)
    @NonNull
    private String email;
    @Column( nullable = true)
    @Nullable
    private String bio;
    @Column( nullable = true)
    @Nullable
    private String img;
}
