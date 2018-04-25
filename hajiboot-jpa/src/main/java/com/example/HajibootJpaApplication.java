package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootApplication
public class HajibootJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer(null,"Yoshiki","Fujita"));
		customerRepository.save(new Customer(null,"Yoshiki","Fujita"));
		customerRepository.save(new Customer(null,"Yoshiki","Fujita"));
		customerRepository.save(new Customer(null,"Yoshiki","Fujita"));

		//第一引数⇢
		Pageable pageable = new PageRequest(0,3);

		customerRepository.findAll().forEach(System.out::println);

		Page<Customer> page = customerRepository.findAll(pageable);
		System.out.println("1ページのデータ数" + page.getSize());
		System.out.println("現在のページ" + page.getNumber());
		System.out.println("すべてのページ" + page.getTotalPages());
		page.getContent().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(HajibootJpaApplication.class, args);
	}
}
