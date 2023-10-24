package com.example.kakao.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/userJoin")
    public void 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        userService.회원가입(userJoinDTO);

    }

    @PostMapping("/api/userId/duplicated")
    public void 중복확인(@RequestBody UserRequest.UserIdDuplicatedDTO request) {
        userService.중복확인(request.getUserId());
    }

}