package com.liang.springmvc;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyCustomizer
 * Package: com.liang.springmvc
 * Description:
 *
 * @Author liang
 * @Create 2025/7/3 10:24
 * @Version jdk17.0
 */

/**
 * 对tomcat容器进行定制化
 */
@Component
public class MyCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory>, Ordered {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
     factory.setPort(8888);//最后还是按application.yml中的配置

    }

    @Override
    public int getOrder() {
        return 0;//按这个来
    }
}
