package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.mayikt.mapper")
public class App {
    /**
     * 主项目启动的时候 走的 com.mayikt.main
     * 全局捕获异常 捕获类 ---com.mayikt.common
     * 解决这个问题呢？
     * 主项目启动的时候 走的 com.mayikt-
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}
