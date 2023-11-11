package com.example.bigdata.user.service;

import com.example.bigdata.user.User;
import com.example.bigdata.user.dto.SignUpRequestDto;
import com.example.bigdata.user.repository.UserRepository;
import com.example.bigdata.util.*;
import com.example.bigdata.util.crypto.CryptoData;
import com.example.bigdata.util.crypto.EncryptedPassword;
import com.example.bigdata.util.crypto.Encryptor;
import com.example.bigdata.util.crypto.SaltGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void join(SignUpRequestDto dto){
        if(checkIsUserExist(dto.getEmail())){
            throw new IllegalArgumentException("이미 등록된 메일입니다.");
        }

        EncryptedPassword pw = encryptPasswordWithSalt(dto.getPassword());
        User user = dto.toEntity(pw.getSalt(), pw.getPassword());
        userRepository.save(user);
    }

    private EncryptedPassword encryptPasswordWithSalt(String plainPassword) {
        String salt = SaltGenerator.generateSalt();
        CryptoData cryptoData = CryptoData.WithSaltBuilder()
                .plainText(plainPassword)
                .salt(salt)
                .build();
        String encryptedPassword = Encryptor.sha256Encrypt(cryptoData);
        return EncryptedPassword.builder()
                .salt(salt)
                .password(encryptedPassword)
                .build();
    }

    private boolean checkIsUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
