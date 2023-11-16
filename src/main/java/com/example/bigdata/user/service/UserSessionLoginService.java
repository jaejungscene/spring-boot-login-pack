package com.example.bigdata.user.service;

import com.example.bigdata.user.User;
import com.example.bigdata.user.dto.SignInRequestDto;
import com.example.bigdata.user.repository.UserRepository;
import com.example.bigdata.util.contant.SessionKey;
import com.example.bigdata.util.crypto.CryptoData;
import com.example.bigdata.util.crypto.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


import jakarta.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserSessionLoginService implements LoginService{

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public void login(SignInRequestDto dto){
        Optional<User> user = userRepository.findByEmail(dto.getEmail());
        if (!user.isPresent()){
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }
        CryptoData cryptoData = CryptoData.WithSaltBuilder()
                .plainText(dto.getPassword())
                .salt(user.get().getSalt())
                .build();
        String encryptedPassword = Encryptor.sha256Encrypt(cryptoData);

        if(!encryptedPassword.equals(user.get().getPassword())){
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
        httpSession.setAttribute(SessionKey.LOGIN_USER_ID, user.get().getId());
    }

    @Override
    public void logout(){
        httpSession.removeAttribute(SessionKey.LOGIN_USER_ID);
    }

    @Override
    public long getLoginUserId() {
        try {
            return (long)httpSession.getAttribute(SessionKey.LOGIN_USER_ID);
        } catch (NullPointerException e) {
            throw new NullPointerException("현재 유저는 로그인 상태가 아닙니다.");
        }
    }
}