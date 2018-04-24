package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner{

    //CommandLineRunnerを用いている場合はAutowiredを利用可能
    @Autowired
    ArgumentResolver argumentResolver;

    @Autowired
    Calculator calculator;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter number like 'a b':");
        Argument argument = argumentResolver.resolver(System.in);
        int result = calculator.calc(argument.getA(),argument.getB());
        System.out.println("result = " + result);
    }

    public static void main(String[] args) {

        //SpringApplication.runの戻り値はDIコンテナの本体である『ApplicationContext』である。
        ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);

    }
}
