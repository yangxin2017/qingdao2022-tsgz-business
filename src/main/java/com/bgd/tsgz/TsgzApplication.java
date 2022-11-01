package com.bgd.tsgz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bgd.tsgz.mapper")
public class TsgzApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsgzApplication.class, args);
    }

}
