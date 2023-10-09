package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot.mapper")
public class SpringbootApplication {

    //https://api.map.baidu.com/location/ip?ak=您的AK
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
