package com.example.mailspring.security;


import com.example.mailspring.models.PersonRegistration;
import com.example.mailspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PersonService service;

    @Autowired
    public PersonDetailsService(PersonService service) {
        this.service = service;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PersonRegistration personByName = service.findByName(username);
        if (personByName == null ){
            throw new UsernameNotFoundException("Not found");
        }

        return new PersonDetails(personByName);
    }
}
