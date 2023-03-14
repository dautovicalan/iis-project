package com.alan.iisuserinterface.controllers;

import com.alan.iisuserinterface.models.NbaTeams;
import com.alan.iisuserinterface.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("xsdValidation")
public class XSDValidationController {

    private static final String API_URL = "http://localhost:5001/api/v1/nbateams/xsd";
    private final RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    @Autowired
    public XSDValidationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @GetMapping
    public String getXsdValidation(Model model){
        model.addAttribute("team", new Team());
        return "xsdValidation";
    }

    @PostMapping("testXsd")
    public String testXsdValidation(@ModelAttribute Team team, Model model){
        NbaTeams nbaTeams = new NbaTeams(List.of(team));
        HttpEntity<NbaTeams> request = new HttpEntity<>(nbaTeams, httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity(API_URL, request, String.class);
        String resultBody = result.getBody();
        System.out.println(resultBody);

        assert resultBody != null;
        model.addAttribute("result", resultBody);
        return "xsdValidation";
    }
}