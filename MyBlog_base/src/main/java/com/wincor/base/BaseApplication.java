package com.wincor.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    //将想用的对象（方法的返回值）放在spring容器中
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
