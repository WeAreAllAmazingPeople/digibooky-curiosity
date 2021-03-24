package com.switchfully.curiosity.digibooky.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ohsilly")
class temp {
    @GetMapping
    public String seyHello() {return "hello that's what you get";}
}
