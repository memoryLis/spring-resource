package com.liang.tool.enviroment;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName: PropertyResource
 * Package: com.liang.tool.resource
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 17:44
 * @Version jdk17.0
 */
@Configuration
@PropertySource("classpath:test.properties")
public class PropertyResource {
}
