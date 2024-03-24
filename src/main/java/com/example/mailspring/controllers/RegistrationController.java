package com.example.mailspring.controllers;



import com.example.mailspring.models.Dto.PersonRegistrationDto;
import com.example.mailspring.models.PersonRegistration;
import com.example.mailspring.service.PersonService;
import com.example.mailspring.service.RegistrationService;
import com.example.mailspring.validation.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class RegistrationController {
    private final PersonValidator validator;

    private final PersonService service;

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(PersonValidator validator, PersonService service,
                                  RegistrationService registrationService) {
        this.validator = validator;
        this.service = service;
        this.registrationService = registrationService;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String giveRegistrationPage(@ModelAttribute("personFromPage") PersonRegistration person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("personFromPage") PersonRegistrationDto personDto, BindingResult result) {

        PersonRegistration personRegistration = PersonRegistration
                .builder()
                .name(personDto.getUsername())
                .password(personDto.getPassword()).age(personDto.getAge()).build();

        validator.validate(personDto, result);

        if (result.hasErrors()) {
            return "/auth/registration";
        }

        registrationService.save(personRegistration);

        return "redirect:/auth/login";
    }
}
