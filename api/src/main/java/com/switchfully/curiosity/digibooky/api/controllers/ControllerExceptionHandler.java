package com.switchfully.curiosity.digibooky.api.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice // Class that offers methods to all controllers
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    //TODO fix typo
    public void handleIllegalArgumenbtException(IllegalArgumentException exception, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }
}
