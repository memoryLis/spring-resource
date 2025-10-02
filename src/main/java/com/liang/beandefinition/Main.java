package com.liang.beandefinition;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * ClassName: ${NAME}
 * Package:
 * Description:
 *
 * @Author liang
 * @Create 2025/6/13 17:09
 * @Version jdk17.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}