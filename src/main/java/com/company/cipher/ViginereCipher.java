package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

@Component
public class ViginereCipher implements Cipher<String> {

    @Override
    public String encrypt(String key, String plainText) {
        StringBuilder cipherText=new StringBuilder();
        int j=0;
        for(int i=0;i<plainText.length();i++){
            char c;
            if(j==key.length()){
                j=0;
            }
            if(Character.isLowerCase(plainText.charAt(i))){
                if(Character.isLowerCase(key.charAt(j))){
                    c = (char)(((int)plainText.charAt(i)-97+
                            ((int) key.charAt(j)-97))%26+97);
                }
                else{
                    c = (char)(((int)plainText.charAt(i)-95+
                            ((int) key.charAt(j)-65))%26+97);
                }
            }
            else{
                if(Character.isLowerCase(key.charAt(j))){
                    c = (char)(((int)plainText.charAt(i)-65+
                            ((int) key.charAt(j)-97))%26+65);
                }
                else{
                    c = (char)(((int)plainText.charAt(i)-65+
                            ((int) key.charAt(j)-65))%26+65);
                }
            }
            j++;
            cipherText.append(c);
        }
        return cipherText.toString();
    }
}
