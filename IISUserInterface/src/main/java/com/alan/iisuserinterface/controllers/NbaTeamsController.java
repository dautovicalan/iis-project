package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.services.NbaTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("nbaTeams")
public class NbaTeamsController {

    private final NbaTeamsService nbaTeamsService;

    @Autowired
    public NbaTeamsController(NbaTeamsService nbaTeamsService) {
        this.nbaTeamsService = nbaTeamsService;
    }

    @GetMapping
    public String getNbaTeams(){
        return "nbaTeams";
    }

    @PostMapping
    public String getData(@RequestParam("teamCode") String teamCode, Model model){
        String nbaTeams = nbaTeamsService.getNbaTeams(teamCode);
        model.addAttribute("data", nbaTeams);
        return "nbaTeams";

    }
}
