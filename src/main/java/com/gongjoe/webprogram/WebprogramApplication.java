package com.gongjoe.webprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gongjoe.webprogram.mapper")
public class WebprogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebprogramApplication.class, args);
    }

}
