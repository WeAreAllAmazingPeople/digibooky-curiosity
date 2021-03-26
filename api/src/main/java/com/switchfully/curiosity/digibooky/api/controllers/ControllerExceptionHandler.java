package com.switchfully.curiosity.digibooky.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice // Class that offers methods to all controllers
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException{
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

}
