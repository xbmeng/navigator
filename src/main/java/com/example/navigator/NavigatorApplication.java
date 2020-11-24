package com.example.navigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.navigator.dao")
public class NavigatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigatorApplication.class, args);
    }

}
