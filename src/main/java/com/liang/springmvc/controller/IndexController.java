package com.liang.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController
 * Package: com.liang.springmvc.controller
 * Description:
 *
 * @Author liang
 * @Create 2025/7/3 15:03
 * @Version jdk17.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/{parm}")
    public String index(@PathVariable String parm) {
        return "index"+parm;
    }
}
