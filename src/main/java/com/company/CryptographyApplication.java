package com.company;

import com.company.cipher.CaesarCipher;
import com.company.common.Cipher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class CryptographyApplication {

    private final CaesarCipher cipher;
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println(cipher.encrypt(4,"ATTACKATONCE"));
            }

        };
        return clr;
    }
    public static void main(String[] args){
        SpringApplication.run(CryptographyApplication.class);
    }
}
