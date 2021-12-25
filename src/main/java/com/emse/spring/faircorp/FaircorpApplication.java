package com.emse.spring.faircorp;

import com.emse.spring.faircorp.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaircorpApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(FaircorpApplication.class, args);
    }

    @Autowired
    InitService initService;
    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        initService.init();
    }

}
