package com.io.io22.controller;

import com.io.io22.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException exception) {
        //todo
        return "";
    }

}
