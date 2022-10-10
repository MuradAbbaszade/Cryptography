package com.company.cipher;

import com.company.common.Cipher;
import org.springframework.stereotype.Component;

@Component
public class ViginereCipher implements Cipher<String> {

    @Override
    public String encrypt(String key, String plainText) {
        plainText = plainText.toLowerCase();
        key=key.toLowerCase();
        StringBuilder cipherText = new StringBuilder();
        int j = 0;
        for (int i = 0; i < plainText.length(); i++) {
            char c;
            if (j == key.length()) {
                j = 0;
            }
            c = (char) ((( plainText.charAt(i) - 97) +
                    (key.charAt(j) - 97)) % 26 + 97);
            cipherText.append(c);
            j++;
        }
        return cipherText.toString();
    }

    @Override
    public String decrypt(String key, String cipherText) {
        cipherText = cipherText.toLowerCase();
        key = key.toLowerCase();
        StringBuilder plainText=new StringBuilder();
        int j=0;
        for(int i=0;i<cipherText.length();i++){
            char c;
            if(j==key.length()){
                j=0;
            }
            if((cipherText.charAt(i)-97)-(key.charAt(j)-97)<0) {
                c = (char) (((cipherText.charAt(i) - 97)-
                        (key.charAt(j) - 97)) % 26 + 26 + 97);
            }
            else {
                c = (char) (((cipherText.charAt(i) - 97)-
                        (key.charAt(j) - 97)) % 26 + 97);
            }
            j++;
            plainText.append(c);
        }
        return plainText.toString();
    }
}
