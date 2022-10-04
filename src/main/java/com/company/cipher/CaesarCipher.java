package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

@Component
public class CaesarCipher implements Cipher {
    @Override
    public String encrypt(int key, String plainText) {
        StringBuilder cipherText= new StringBuilder();
        for(int i=0;i<plainText.length();i++){
            if(Character.isLowerCase(plainText.charAt(i))){
                char c = (char)(((int)plainText.charAt(i) +
                        key - 97) % 26 + 97);
                cipherText.append(c);
            }
            else{
                char c = (char)(((int)plainText.charAt(i) +
                        key - 65) % 26 + 65);
                cipherText.append(c);
                }
            }
        return cipherText.toString();
    }
}
