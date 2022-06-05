package com.example.springmvc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private Date timestamp;
    private String details;
}
