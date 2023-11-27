package com.pack.login.user.service;

import com.pack.login.user.dto.SignInRequestDto;

public interface LoginService {

    void login(SignInRequestDto dto);

    void logout();

    long getLoginUserId();
}