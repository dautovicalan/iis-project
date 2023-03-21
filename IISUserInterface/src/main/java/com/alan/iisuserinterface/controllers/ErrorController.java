package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ErrorController extends AbstractErrorController {
    private static final String ERROR_PATH=  "/error";

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound(){
        return "404";
    }

}
