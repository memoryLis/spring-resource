package com.liang.tool.resource;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: ResourceTest
 * Package: com.liang.tool.resource
 * Description:
 *
 * @Author liang
 * @Create 2025/6/25 16:48
 * @Version jdk17.0
 */
public class ResourceTest {
    @Test
    public void testUrlPathResource() throws IOException {
        Resource resource = new UrlResource("https://cn.bing.com/images/search?q=%e5%9b%be%e7%89%87&id=457EC80FCD5EE9AB67B2B3E8F5624312D6F6400B&form=IACFIR&first=1&disoverlay=1");
        // 建立一个D盘的文件流
        FileOutputStream fos = new FileOutputStream("D://"+resource.getFilename());
        // 使用IOUtils进行拷贝
        IOUtils.copy(resource.getInputStream(), fos);
    }
}
