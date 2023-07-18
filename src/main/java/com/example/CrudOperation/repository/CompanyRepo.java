package com.example.CrudOperation.repository;

import com.example.CrudOperation.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {

    Company findByCompanyName(String name);
}
