package com.example.springmvc.controller;



import com.example.springmvc.beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {

    @Autowired
    HelloWorldBean helloWorldBean;

    @GetMapping( "/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping( "/hellobean")
    public HelloWorldBean helloWorldBean() {
        return helloWorldBean;
    }


}
