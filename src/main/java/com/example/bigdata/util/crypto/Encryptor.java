package com.example.bigdata.util.crypto;

import java.security.MessageDigest;

public class Encryptor {
    public static String sha256Encrypt(CryptoData cryptoData){
        try {
            // 1)
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String rawAndSalt = cryptoData.getPlainText() + cryptoData.getSalt();
            //System.out.println("{SHA256.Class} rawAndSalt : " + rawAndSalt);

            // 2)
            md.update(rawAndSalt.getBytes());

            // 3)
            byte[] byteData = md.digest(); // 1byte = 8bit

            // 4)
            StringBuffer hexString = new StringBuffer();
            for(int i = 0; i < byteData.length; ++i) {
                String hex = Integer.toHexString(255 & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');// 각 byteData당 두 자리 수 16진수로 변환
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception var7) {
            var7.printStackTrace();
            throw new RuntimeException();
        }
    }


}
