package com.happiness;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HappinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappinessApplication.class, args);
    }

    @RestController
    static class MyController {
        @RequestMapping("/")
        public String hello() {
            return "hello";
        }
    }
}
