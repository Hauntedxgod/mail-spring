package com.example.mailspring.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;



@Repository
public interface EmailServiceImpl {
    public String senMail(MultipartFile[] file, String to, String[] cc, String subject, String body);
}
