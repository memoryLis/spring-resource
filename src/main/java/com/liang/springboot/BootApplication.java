package com.liang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * ClassName: BootApplication
 * Package: com.liang.springboot
 * Description:
 *
 * @Author liang
 * @Create 2025/7/4 10:00
 * @Version jdk17.0
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
