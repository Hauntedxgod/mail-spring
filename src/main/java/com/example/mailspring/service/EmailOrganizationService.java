package com.example.mailspring.service;


import com.example.mailspring.models.EmailOrganizations;
import com.example.mailspring.repositories.EmailOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailOrganizationService {

    private final EmailOrganizationRepository repository;


    @Autowired
    public EmailOrganizationService(EmailOrganizationRepository repository) {
        this.repository = repository;
    }


    public List<EmailOrganizations> getAllEmail() {
        return repository.findAll();
    }
}
