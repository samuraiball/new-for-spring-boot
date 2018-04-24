package com.example.hajibootdi;

import com.example.AppConfig;
import com.example.app.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

//@SpringBootApplicationは@EnableAutoConfiguration,@Configuration,@ComponentScanをあわせたものである。
@EnableAutoConfiguration

//JavaConfig読み込み
@Import(AppConfig.class)
public class HajibootDiApplication {

    public static void main(String[] args) {

        //SpringApplication.runの戻り値はDIコンテナの本体である『ApplicationContext』である。
        ApplicationContext context = SpringApplication.run(HajibootDiApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 2 number like 'a b':");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //取得の際にInterfaceのCalculatorクラス型を指定、実態クラスはIDコンテナ側で解決される。
        //これによって、APP側はDIコンテナの中の実態クラスを知る必要がない。
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.calc(a, b);
        System.out.println("result = " + result);
    }
}
