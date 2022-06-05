package com.example.springmvc.controller;



import com.example.springmvc.beans.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class MvcController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    HelloWorldBean helloWorldBean;

    @GetMapping( "/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping( "/hellointernationalized")
    public String hellointernationalized(
            @RequestHeader(name = "Accept-Language",required = false)Locale locale) {
        return messageSource.getMessage("message.hello",null,"default", locale);
    }

    @GetMapping( "/hellobean")
    public HelloWorldBean helloWorldBean() {
        return helloWorldBean;
    }


}
