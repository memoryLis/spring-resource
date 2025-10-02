package com.liang.tool.conversionservice;

import com.liang.tool.bean.UserTool;
import com.liang.tool.conversionservice.convert.StringToUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * ClassName: ConversionServiceTest
 * Package: com.liang.tool.conversionservice
 * Description:
 *
 * @Author liang
 * @Create 2025/6/19 17:00
 * @Version jdk17.0
 */
@Slf4j
public class ConversionServiceTest {
    @Test
    public void test(){
        ConversionService conversionService = new DefaultConversionService();
        String a = "123";
        boolean b = conversionService.canConvert(a.getClass(), Integer.class);
        if(b){
            Integer convert = conversionService.convert(a, Integer.class);
            log.info("convert to Integer: {}", convert);

        }

    }


    @Test
    public void test1(){
        GenericConversionService conversionService = new GenericConversionService();
        String a = "12|DSFAS";
        conversionService.addConverter(new StringToUser());
        boolean b = conversionService.canConvert(String.class, UserTool.class);
        if(b){
            UserTool convert = conversionService.convert(a, UserTool.class);
            log.info("convert to Integer: {}", convert);

        }

    }

}
