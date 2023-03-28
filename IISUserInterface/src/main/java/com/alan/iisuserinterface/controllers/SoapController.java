package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.services.SoapService;
import com.alan.soap.nba.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("soap")
public class SoapController {

    private final SoapService soapService;

    @Autowired
    public SoapController(SoapService soapService) {
        this.soapService = soapService;
    }

    @GetMapping
    public String getSoap(){
        return "soap";
    }

    @PostMapping
    public String soapSearchTeamCode(@RequestParam("teamCode") String teamCode, Model model){
        Optional<Team> teamByCode = soapService.findTeamByCode(teamCode);
        if (teamByCode.isEmpty()){
            model.addAttribute("data", "No such team");
            return "soap";
        }
        model.addAttribute("data",
                "Team Name: " + teamByCode.get().getName() +
                        "\nTeam Code: " + teamByCode.get().getCode() +
                        "\n Team Nickname: " + teamByCode.get().getNickname());
        return "soap";
    }
}
