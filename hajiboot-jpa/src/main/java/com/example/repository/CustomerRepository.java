package com.example.repository;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //JPQLを記述する。
    //@Query("SELECT x FROM customers x ORDER BY x.first_name, x.last_name")
    //List<Customer> findAllOrderByName();
}