package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class AffineCipher implements Cipher<List<Integer>> {
    @Override
    public String encrypt(List<Integer> key, String plainText) {
        plainText = plainText.toLowerCase();
        StringBuilder cipherText = new StringBuilder();
        for(int i=0;i<plainText.length();i++){
            char c ;
                c=(char)((key.get(0)*(plainText.charAt(i)-96)+key.get(1))%26+96);
            cipherText.append(c);
        }
        return cipherText.toString();
    }

    @Override
    public String decrypt(List<Integer> key, String cipherText) {
        cipherText = cipherText.toLowerCase();
        StringBuilder plainText = new StringBuilder();
        BigInteger inverse = BigInteger.valueOf(key.get(0)).modInverse(BigInteger.valueOf(26));
        for(int i=0;i<cipherText.length();i++){
            char c ;
            int decoded = inverse.intValue() * (cipherText.charAt(i) - 'a' - key.get(1) + 26);
            c = (char) (decoded % 26 + 'a');
            plainText.append(c);
        }
        return plainText.toString();
    }
}
