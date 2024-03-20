package com.example.mailspring.service;


import com.example.mailspring.models.PersonRegistration;
import com.example.mailspring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository peopleRepository;

    @Autowired
    public PersonService(PersonRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public PersonRegistration findByName(String name){
        return peopleRepository.findByName(name);
    }
}
