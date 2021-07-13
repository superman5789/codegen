package com.example.codegen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = { "com.example.codegen.mapper" })
@SpringBootApplication
public class CodegenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodegenApplication.class, args);
    }

}
