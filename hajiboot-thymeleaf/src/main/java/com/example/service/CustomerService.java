package com.example.service;

import com.example.domain.Customer;
import com.example.domain.User;
import com.example.repository.CustomerRepositoryWithJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositoryWithJPA customerRepository;


    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAll(){
       return customerRepository.findAll();

    }

    public Customer findOne(Integer id){
        return customerRepository.getOne(id);
    }

    public Customer create(Customer customer, User user){
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, User user){
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public void delete(Integer id){
       Customer customer= customerRepository.getOne(id);
        customerRepository.delete(customer);
    }
}
