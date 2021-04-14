package com.md.consumer.api;

import com.md.consumer.api.localinfra.LocalTestInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyTest {
    @Autowired
    private LocalTestInfra localTestInfra;
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String showinfo(@RequestParam String name, @RequestParam String password) {
        return localTestInfra.showinfo(name,password);
    }

}
