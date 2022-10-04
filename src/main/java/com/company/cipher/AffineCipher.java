package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AffineCipher implements Cipher<List<Integer>> {
    @Override
    public String encrypt(List<Integer> key, String plainText) {
        StringBuilder cipherText = new StringBuilder();
        for(int i=0;i<plainText.length();i++){
            char c ;
            if(Character.isLowerCase(plainText.charAt(i))){
                c=(char)((key.get(0)*(plainText.charAt(i)-96)+key.get(1))%26+96);
            }
            else{
                c=(char)((key.get(0)*(plainText.charAt(i)-64)+key.get(1))%26+64);
            }
            cipherText.append(c);
        }
        return cipherText.toString();
    }
}
