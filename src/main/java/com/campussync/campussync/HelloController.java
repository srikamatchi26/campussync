package com.campussync.campussync;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello! CampusSync is running. Built by Srikmatchi.";
    }
}