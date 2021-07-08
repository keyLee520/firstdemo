package com.pipi.firstdemo.controller;

import com.pipi.firstdemo.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestDao testDao;

    @Value("${useLocalCache:none}")
    private String nacosValue;

    @GetMapping("/1")
    public Object test1() {
        return testDao.getAllUsers();
    }

    @GetMapping("/2")
    public Object getConfig(){
        return nacosValue;
    }
}
