package com.switchfully.curiosity.digibooky.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice // Class that offers methods to all controllers
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public void handleIllegalStateException(IllegalStateException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

}
