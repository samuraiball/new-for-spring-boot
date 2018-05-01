package com.example.service;

import com.example.repository.CustomerRepositoryWithJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceWithJPA {

    @Autowired
    CustomerRepositoryWithJPA customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Page<Customer> findAll(Pageable pageable){
       return customerRepository.findAll(pageable);

    }


    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }
}
