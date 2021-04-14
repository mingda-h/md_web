package com.md.infra;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface TestInfra {
    @PostMapping("/hi")
    String showinfo(@RequestParam String name, @RequestParam String password);
}
