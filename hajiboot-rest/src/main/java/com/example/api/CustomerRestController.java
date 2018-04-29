package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    //GetMappingでは返り値がJson型にシリアライズ化されてHTTPボディに格納される。
    @GetMapping
    List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping(path = "{id}")
    Customer getCustomer(@PathVariable Integer id) {
        return customerService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomer(@RequestBody Customer customer) {
        System.out.println("aaaa");
        return customerService.create(customer);
    }

    @PutMapping(path = "{id}")
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
