package com.example.springmvc.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HelloWorldBean {

    private String message = "Hello world";


}
