package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.DemoUser;

@Controller
public class DemoUserController {

    @PostMapping("/")
    public void create(DemoUser user){

    }
}
