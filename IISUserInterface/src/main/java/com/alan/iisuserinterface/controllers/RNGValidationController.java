package com.alan.iisuserinterface.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rng")
public class RNGValidationController {

    @GetMapping
    public String getRngValidation(){
        return "rngValidation";
    }
}
