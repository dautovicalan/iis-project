package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.models.Team;
import com.alan.iisuserinterface.services.XSDValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("xsdValidation")
public class XSDValidationController {
    private final XSDValidationService xsdValidationService;

    @Autowired
    public XSDValidationController(XSDValidationService xsdValidationService) {
        this.xsdValidationService = xsdValidationService;
    }

    @GetMapping
    public String getXsdValidation(Model model){
        model.addAttribute("team", new Team());
        return "xsdValidation";
    }

    @PostMapping
    public String testXsdValidation(@ModelAttribute Team team, Model model){
        String output = xsdValidationService.testXsdValidation(team);
        model.addAttribute("result", output);
        return "xsdValidation";
    }
}