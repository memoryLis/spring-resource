package com.liang.tool.enviroment;

import com.liang.beandefinition.bean.Dog;
import com.liang.tool.bean.Brid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ClassName: ProfileConfigure
 * Package: com.liang.tool.enviroment
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 18:18
 * @Version jdk17.0
 */
@Configuration
public class ProfileConfigure {
    @Bean
    @Profile("dev")
    public Brid bird1() {
        return new Brid(99);
    }

    @Bean
    @Profile("test")
    public Brid bird2() {
        return new Brid(66);
    }
}
