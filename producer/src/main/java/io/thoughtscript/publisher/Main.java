package io.thoughtscript.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.thoughtscript.publisher"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}