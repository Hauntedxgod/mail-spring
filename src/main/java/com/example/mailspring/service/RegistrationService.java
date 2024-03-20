package com.example.mailspring.service;



import com.example.mailspring.models.PersonRegistration;
import com.example.mailspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(PersonRegistration person) {
        String password = passwordEncoder.encode(person.getPassword());
        person.setRole("ROLE_USER");
        person.setPassword(password);
        personRepository.save(person);
    }
}

