package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryWithJPA extends JpaRepository<Customer,Integer>{
}
