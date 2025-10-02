package com.liang.beandefinition.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: Animal
 * Package: com.liang.bean
 * Description:
 *
 * @Author liang
 * @Create 2025/6/18 15:42
 * @Version jdk17.0
 */
@Component
public class Animal {
    public String name;
    public void eat(){
        System.out.println("吃吃吃");
    }

}
