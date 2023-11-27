package com.pack.login.util;

import com.pack.login.util.crypto.SaltGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CryptoTest {

    @Test
    @DisplayName("encryption test")
    void encryptionTest() throws Exception{

    }

    @Test
    void TestClassTest() throws  Exception{
        System.out.println(
                TestClass.add("asdf", "qwer")
                );
        System.out.println(
                SaltGenerator.generateSalt()
        );
        System.out.println(
                TestClass.createSalt("asdf")
        );
    }
}
