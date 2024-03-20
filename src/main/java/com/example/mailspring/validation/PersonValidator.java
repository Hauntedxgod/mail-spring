package com.example.mailspring.validation;


import com.example.mailspring.models.Dto.PersonRegistrationDto;
import com.example.mailspring.models.PersonRegistration;
import com.example.mailspring.security.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService service;

    @Autowired
    public PersonValidator(PersonDetailsService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonRegistration.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonRegistrationDto p = (PersonRegistrationDto) target;

        try {
            service.loadUserByUsername(p.getUsername());
        } catch (UsernameNotFoundException e) {
            return;
        }

        errors.rejectValue("username" , "100" , "User with this nickname existed");

    }
}
