package com.company;

import com.company.cipher.AffineCipher;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class CryptographyApplication {

    private final AffineCipher cipher;
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println(cipher.encrypt(Arrays.asList(7,9),"IAMSECRET"));
            }

        };
        return clr;
    }
    public static void main(String[] args){
        SpringApplication.run(CryptographyApplication.class);
    }
}
