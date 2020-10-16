package com.loock.thinkmore.asynctask.controller;

import com.loock.thinkmore.asynctask.serviceinterface.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author loock
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService service;

    @RequestMapping("/hello")
    public String hello(){
        service.hello();
        return "ok";
    }
}
