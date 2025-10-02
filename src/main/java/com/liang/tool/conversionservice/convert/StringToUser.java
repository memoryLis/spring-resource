package com.liang.tool.conversionservice.convert;

import com.liang.tool.bean.UserTool;
import org.springframework.core.convert.converter.Converter;

/**
 * ClassName: StringToUser
 * Package: com.liang.tool.conversionservice.convert
 * Description:
 *
 * @Author liang
 * @Create 2025/6/19 17:26
 * @Version jdk17.0
 */
public class StringToUser implements Converter<String, UserTool> {
    // "12| liang"
    @Override
    public UserTool convert(String source) {
        if(source.contains("|")){
            String [] split = source.split("\\|");
            UserTool user = new UserTool();
            user.setId(Integer.parseInt(split[0]));
            user.setName(split[1]);
            return user;
        }
        return null;
    }
}
