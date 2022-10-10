package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

@Component
public class CaesarCipher implements Cipher<Integer> {
    @Override
    public String encrypt(Integer key, String plainText) {
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

    @Override
    public String decrypt(Integer key, String cipherText) {
        StringBuilder plainText= new StringBuilder();
        for(int i=0;i<cipherText.length();i++){
            if(Character.isLowerCase(cipherText.charAt(i))){
                if(cipherText.charAt(i)-key<0) {
                    char c = (char) (((cipherText.charAt(i) - key) +26 - 97) % 26 + 97);
                    plainText.append(c);
                }
                else{
                    char c = (char) (((cipherText.charAt(i) - key) - 97) % 26 + 97);
                    plainText.append(c);
                }
            }
            else{
                if(cipherText.charAt(i)-key<0) {
                    char c = (char) (((cipherText.charAt(i) - key) +26 - 65) % 26 + 65);
                    plainText.append(c);
                }
                else{
                    char c = (char) (((cipherText.charAt(i) - key) - 65) % 26 + 65);
                    plainText.append(c);
                }
            }
        }
        return plainText.toString();
    }
}
