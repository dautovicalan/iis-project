package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.models.Team;
import com.alan.iisuserinterface.services.RNGValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rngValidation")
public class RNGValidationController {

    private final RNGValidationService rngValidationService;

    @Autowired
    public RNGValidationController(RNGValidationService rngValidationService) {
        this.rngValidationService = rngValidationService;
    }

    @GetMapping
    public String getRngValidation(Model model){
        model.addAttribute("team", new Team());
        return "rngValidation";
    }

    @PostMapping
    public String testRngValidation(@ModelAttribute Team team, Model model){
        String output = rngValidationService.testRngValidation(team);
        model.addAttribute("result", output);
        return "rngValidation";
    }
}
