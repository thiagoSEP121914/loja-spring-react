package com.dev.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class Hello {

    @GetMapping("/ola")
    public String hello () {
        return "Hello, world " + new Date();
    }

}
