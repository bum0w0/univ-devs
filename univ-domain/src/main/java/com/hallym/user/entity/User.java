package com.hallym.user.entity;

import com.hallym.user.model.Provider;
import com.hallym.user.model.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Provider provider;    // KAKAO, NAVER, GOOGLE, LOCAL

    @Column(unique = true)
    private String socialId;    // 소셜 로그인 ID (ex. 카카오 회원번호 등)

    @Enumerated(EnumType.STRING)
    private Role role;            // USER, ADMIN 등

}