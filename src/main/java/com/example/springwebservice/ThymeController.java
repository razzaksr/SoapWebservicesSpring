package com.example.springwebservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class ThymeController {
    @GetMapping("/")
    public String ind(){
        return "index";
    }
}
