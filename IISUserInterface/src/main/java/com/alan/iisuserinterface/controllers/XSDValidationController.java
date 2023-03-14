package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.models.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("xsd")
public class XSDValidationController {

    @GetMapping
    public String getXsdValidation(Model model){
        model.addAttribute("team", new Team());
        return "xsdValidation";
    }

    @PostMapping("testXsd.html")
    public String testXsdValidation(@ModelAttribute Team team){
        System.out.println(team);
        return "xsdValidation";
    }
}