package com.example.hajiboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//auto-configが有効になる
@SpringBootApplication
@RestController
public class HajibootApplication {


    @GetMapping("/")
    String home(){
        return "Hello world";
    }

    public static void main(String[] args){
        SpringApplication.run(HajibootApplication.class,args);
    }
}
