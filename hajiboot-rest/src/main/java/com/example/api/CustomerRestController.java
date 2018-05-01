package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerServiceWithJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    @Autowired
    CustomerServiceWithJPA customerService;

    //GetMappingでは返り値がJson型にシリアライズ化されてHTTPボディに格納される。
    @GetMapping
    //@PageableDefaultはページ指定がなかった場合、「page」と「size」のデフォルトを設定している。
    //default page=0 size= 20
    //パラメータは0始まり
    Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @GetMapping(path = "{id}")
    Customer getCustomer(@PathVariable Integer id) {
        //  return customerService.findOne(id);
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Customer> postCustomer(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {

        Customer csutomer = customerService.create(customer);
        URI location = uriBuilder.path("api/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping(path = "{id}")
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        // customerService.delete(id);
    }
}
