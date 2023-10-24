package com.example.kakao.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserJPARepository userJPARepository;

    @Transactional
    public void 회원가입(UserRequest.UserJoinDTO userJoinDTO) {

        checkUserId(userJoinDTO.getUserId());
        User user = User.builder()
                .userId(userJoinDTO.getUserId())
                .userPassword(userJoinDTO.getUserPassword())
                .username(userJoinDTO.getUsername())
                .userEmail(userJoinDTO.getUserEmail())
                .userBirth(userJoinDTO.getUserBirth())
                .userGender(userJoinDTO.getuserGender())
                .build();
        userJPARepository.save(user);
    }

    private void checkUserId(String userId) {
        Optional<User> optUser = userJPARepository.findByUserId(userId);
        optUser.ifPresent(user -> {
            throw new RuntimeException("중복된 아이디입니다");
        });
    }

    public void 중복확인(String userLoginId) {
        checkUserId(userLoginId);

    }

}
