package com.example.bigdata.user.service;

import com.example.bigdata.user.dto.SignInRequestDto;

public interface LoginService {

    void login(SignInRequestDto dto);

    void logout();

    long getLoginUserId();
}