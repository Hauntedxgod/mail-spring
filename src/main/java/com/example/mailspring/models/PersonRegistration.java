package com.example.mailspring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "mail_person_security")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonRegistration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , unique = true)
    @Size(min = 2 , max = 50 , message = "Min 2 chars , max 50 chars")
    private String name;

    @Column(name = "age")
    @Min(value = 1 , message = "Min 1 years")
    private Integer age;

    @Column(name = "password")
    @Size(min = 8 , message = "Min 8 chars , max 15 chars")
    private String password;

    @Column(name = "role")
    private String role;
}
