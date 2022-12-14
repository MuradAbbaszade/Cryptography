package com.company.common;

public interface Cipher<E> {
    String encrypt(E key,String plainText);
    String decrypt(E key,String cipherText);
}
