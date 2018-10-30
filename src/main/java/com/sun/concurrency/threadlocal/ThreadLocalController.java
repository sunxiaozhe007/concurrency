package com.sun.concurrency.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program concurrency
 * @author: sunxiaozhe
 * @create: 2018/10/22 17:22
 */
@Controller
@RequestMapping("/threadlocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test(){
        return RequestHolder.getId();
    }


}
