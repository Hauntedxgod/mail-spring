package com.example.mailspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class MailSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailSpringApplication.class, args);
    }


    @Bean
    public JavaMailSenderImpl mailSender() {
        return new JavaMailSenderImpl();
    }

}
