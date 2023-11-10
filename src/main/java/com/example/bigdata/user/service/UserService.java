package com.example.bigdata.user.service;

import com.example.bigdata.user.User;
import com.example.bigdata.user.dto.SignUpRequestDto;
import com.example.bigdata.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    @Qualifier("sha256Encryptor")
//    private final Encryptor encryptor;

    public void join(SignUpRequestDto dto){
        User user = dto.toEntity();
        userRepository.save(user);

//        if(checkIsUserExist(dto.getEmail())){
//            throw new IllegalArgumentException("이미 등록된 메일입니다.");
//        }
//        EncryptedPas
    }

//    private EncryptedPassword encryptPasswordWithSalt(String plainPassword) {
//        String salt = SaltGenerator.generateSalt();
//        CryptoData cryptoData = CryptoData.WithSaltBuilder()
//                .plainText(plainPassword)
//                .salt(salt)
//                .build();
//        String encryptedPassword = encryptor.encrypt(cryptoData);
//        return EncryptedPassword.builder()
//                .salt(salt)
//                .password(encryptedPassword)
//                .build();
//    }

    private boolean checkIsUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
