package com.liang.beandefinition;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: Test
 * Package: com.liang
 * Description:
 *
 * @Author liang
 * @Create 2025/6/18 16:40
 * @Version jdk17.0
 */
@Slf4j(topic = "c.Test")
public class Test {
    int age;
    public static void main(String[] args) {
         Integer []a={1,2,3,4,5,6,7,8,9};
         List<Integer> list= Arrays.asList(a);
        List<Integer> collect = list.stream().filter(e -> e % 2 == 0).map(e-> e*10).collect(Collectors.toList());
        System.out.println(collect);

    }
}
