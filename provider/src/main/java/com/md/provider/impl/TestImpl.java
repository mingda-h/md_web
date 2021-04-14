package com.md.provider.impl;

import com.md.infra.TestInfra;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
//bean的注解
@Service
public class TestImpl implements TestInfra {
    @Override
    public String showinfo(String name, String password){
        return "嗨 "+name+",你的密码是:" +password+",竟然还有";
    }
}
