package com.example.mailspring.controllers;

import com.example.mailspring.service.EmailOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class EmailOrganizationController {

    private final EmailOrganizationService service;

    @Autowired
    public EmailOrganizationController(EmailOrganizationService service) {
        this.service = service;
    }


    @GetMapping("/email")
    public String getAllEmail(Model model){
        model.addAttribute("allEmail", service.getAllEmail());
        return "email";
    }
}
