package com.aladdin.servicefeign.web;

import com.aladdin.servicefeign.service.FeignServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    FeignServiceHi feignServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return feignServiceHi.sayHiFromClientOne(name);
    }
}


