package com.example.kakao.user;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @NoArgsConstructor
    @Getter
    public static class UserJoinDTO {
        private String userId;
        private String userPassword;
        private String username;
        private String userEmail;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate userBirth;
        private String userGender;

        // enum.valueOf (String)이 String 변수를 읽어서 enum 타입으로 바꿔준다.
        public Gender getuserGender() {
            return Gender.valueOf(userGender.toUpperCase());
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UserIdDuplicatedDTO {
        private String userId;
    }

}