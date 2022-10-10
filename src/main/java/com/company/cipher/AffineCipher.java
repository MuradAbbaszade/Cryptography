package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

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
        for(int i=0;i<cipherText.length();i++){
            char c ;
            int x = (~key.get(0)*(cipherText.charAt(i)-key.get(1)))%26;
            if(x<0){
                c=(char)(x+26+97);
            }else{
                c=(char)(x+97);
            }
            plainText.append(c);
        }
        return plainText.toString();
    }
}
