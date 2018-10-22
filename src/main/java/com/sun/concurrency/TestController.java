package com.sun.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/20 21:01
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "test";
    }

}
