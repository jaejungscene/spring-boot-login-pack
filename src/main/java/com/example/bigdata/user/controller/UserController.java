package com.example.bigdata.user.controller;

import com.example.bigdata.user.dto.SignUpRequestDto;
import com.example.bigdata.user.service.UserService;
import com.example.bigdata.util.StatusEnum;
import com.example.bigdata.util.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sing-up")
    public SuccessResponse singUp(@RequestBody final SignUpRequestDto requestDto) {
        userService.join(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("회원가입 성공")
                .build();
        return res;
    }
}
