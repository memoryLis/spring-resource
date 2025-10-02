package com.liang.beandefinition.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * ClassName: User
 * Package: com.liang.bean
 * Description:
 *
 * @Author liang
 * @Create 2025/6/18 15:28
 * @Version jdk17.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
     int age;
     String name;
}
