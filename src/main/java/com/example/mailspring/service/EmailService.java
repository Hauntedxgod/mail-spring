package com.example.mailspring.service;


import com.example.mailspring.repositories.EmailRepository;
import com.example.mailspring.service.impl.EmailServiceImpl;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService implements EmailServiceImpl {





    @Value("${spring.mail.username}")
    private String fromEmail;




    private JavaMailSender javaMailSender;


    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public String senMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            for (int i = 0; i < file.length ; i++) {
                mimeMessageHelper.addAttachment(
                        file[i].getOriginalFilename(),
                        new ByteArrayResource(file[i].getBytes())
                );
            }

            javaMailSender.send(mimeMessage);

            return "mail send";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    private final EmailRepository emailRepository;
//
//    private final JavaMailSender javaMailSender;
//
//    @Value("")
//    private String senderEmail;
//
//    @Value("")
//    private String senderText;
//
//    @Autowired
//    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
//        this.emailRepository = emailRepository;
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void sendSimpleEmail(String receiver){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom(senderEmail);
//        mailMessage.setTo(receiver);
//        mailMessage.setSubject("Текст"); //Заголовок
//        mailMessage.setText("Второя строка текста");
//        javaMailSender.send(mailMessage);
//    }
//
//
//    public List<Email> getAllNameEmail(){
//        return emailRepository.findAll();
//    }




}
