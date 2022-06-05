package com.example.springmvc.beans;

import lombok.*;

import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {


    private int id;
    @Size(min = 2, message = "name must have at-least two characters")
    private String name;

}
