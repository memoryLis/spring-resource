package com.liang.tool.resource;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * ClassName: PathMatchingResourcePatternResolverTest
 * Package: com.liang.tool.resource
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 15:52
 * @Version jdk17.0
 */
@Slf4j
public class PathMatchingResourcePatternResolverTest {
    /**
     * classpath*: 和classpath的区别： classpath:只会到你的target下面的class路径中查找找文件，
     * classpath*:会到你的target下面的class路径中查找找文件，以及引用jar包中的文件
     * @throws IOException
     */

    @Test
    public void pathMatchingResourcePatternResolverTest() throws IOException {
        /**
         * PathMatchingResourcePatternResolver 处理classpath*: war:
         */
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        resolver.getResources("classpath*:META-INF/spring.components");
        resolver.getResources("classpath*:META-INF/spring.factories");
        log.info("加载了{}个resource",resolver.getResources("classpath*:META-INF/spring.factories").length);


    }

    /**
     * DefaultResourceLoader 处理单个资源，负责匹配 classpath: https:
     */
    @Test
    public void testDefaultResourceLoader(){
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

        defaultResourceLoader.getResource("classpath:META-INF/spring.factories");


    }
}
