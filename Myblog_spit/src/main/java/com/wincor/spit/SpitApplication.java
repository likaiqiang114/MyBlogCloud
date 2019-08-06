package com.wincor.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class SpitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    //mongodb的下划线id用它来指定
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
