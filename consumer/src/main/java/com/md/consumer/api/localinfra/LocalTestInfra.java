package com.md.consumer.api.localinfra;

import com.md.infra.TestInfra;
//import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;

// 接口A 继承 AA ,然后AA 由AAImpl实现，而且还是跨子工程实现，使用该注解让注入时能找到bean,当然还需要在主类运行时进行扫描整个项目
@FeignClient(value = "provider",contextId = "LocalTestInfra")
public interface LocalTestInfra extends TestInfra {
}
