package com.example.mailspring.repositories;

import com.example.mailspring.models.EmailOrganizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailOrganizationRepository extends JpaRepository<EmailOrganizations, Long> {
}
