package com.example.mailspring.controllers;



import com.example.mailspring.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping()
public class EmailControllers {

    private final EmailServiceImpl emailService;


    @Autowired
    public EmailControllers(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }


//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @GetMapping()
//    public String getAllEmail(Model model){
//        model.addAttribute("allEmail" , emailService.getAllNameEmail());
//        return "email";
//    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/send")
    public String sendSimpleEmail(@RequestParam(value = "file" , required = false)MultipartFile[] file ,  String to,
                                  String[] cc , String subject , String body ){

        return emailService.senMail(file , to , cc , subject , body);
    }
}
