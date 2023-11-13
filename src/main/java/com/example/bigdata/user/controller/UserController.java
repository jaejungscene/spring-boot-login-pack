package com.example.bigdata.user.controller;

import com.example.bigdata.user.dto.SignInRequestDto;
import com.example.bigdata.user.dto.SignUpRequestDto;
import com.example.bigdata.user.service.LoginService;
import com.example.bigdata.user.service.UserService;
import com.example.bigdata.util.FailResponse;
import com.example.bigdata.util.Response;
import com.example.bigdata.util.StatusEnum;
import com.example.bigdata.util.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public SuccessResponse signUp(@Valid @RequestBody final SignUpRequestDto requestDto) {
        userService.join(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("회원가입 성공")
                .build();
        return res;
    }

    @PostMapping("/login")
    public SuccessResponse loginUser(@Valid @RequestBody final SignInRequestDto requestDto) {
        loginService.login(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.OK)
                .message("로그인 성공")
                .build();
        return res;
    }

    @GetMapping("/logout")
    public void logoutUser(){
        loginService.logout();
    }

//    @GetMapping("/get")
//    public long getSessionID(){
//        return loginService.getLoginUserId();
//    }
}
