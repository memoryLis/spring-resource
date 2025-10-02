package com.liang.springmvc;

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
public class MVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(MVCApplication.class, args);
    }
}