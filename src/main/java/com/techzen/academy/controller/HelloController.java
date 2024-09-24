package com.techzen.academy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // http://localhost:8080/hello
    @RequestMapping("/hello")
    public String greeting(@RequestParam(defaultValue = "QuangNN") String name,
                           @RequestParam(defaultValue = "VietNam") String address) { // Có thể truyền vào tên
        // Hoàng => Hello Hoàng
        // Yến => Hello Yến
//        return "Hello " + name + " - " + address;

        return String.format("Hello %s - %s", name, address);
    }
}
