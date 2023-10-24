package com.example.kakao.user;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 유저 아이디
    @Column(length = 100, nullable = false, unique = true)
    private String userId; // 인증시 필요한 필드
    // 유저 패스워드
    @Column(length = 256, nullable = false)
    private String userPassword;
    // 사용자명
    @Column(length = 45, nullable = false)
    private String username;
    // 유저 이메일
    @Column(length = 45, nullable = false)
    private String userEmail;
    // 유저 생년월일
    private LocalDate userBirth;
    // 유저 성별
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    // 구분
    // @Nullable
    // @ColumnDefault("'user")
    // private String role;
    // // 유저 사진
    // @Column(length = 100, nullable = true)
    // private String userPic;
    // // 시간 자동입력
    // @CreationTimestamp
    // private Timestamp CrateDate;

}