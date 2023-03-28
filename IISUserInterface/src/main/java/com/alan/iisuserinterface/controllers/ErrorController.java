package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorController extends AbstractErrorController {

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound(){
        return "404";
    }

}
