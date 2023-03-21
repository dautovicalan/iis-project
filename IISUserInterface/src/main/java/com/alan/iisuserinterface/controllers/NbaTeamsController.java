package com.alan.iisuserinterface.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("nbaTeams")
public class NbaTeamsController {

    private static final String API_URL = "https://api-nba-v1.p.rapidapi.com/teams";
    private final RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    public NbaTeamsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-RapidAPI-Key", "388c8cc2dbmsh1df53eecce6aa75p169774jsn8123550febb4");
        httpHeaders.add("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");
    }

    @GetMapping
    public String getNbaTeams(Model model){
        return "nbaTeams";
    }

    @PostMapping("getData")
    public String getData(String data, Model model){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-nba-v1.p.rapidapi.com/teams"))
                .header("X-RapidAPI-Key", "388c8cc2dbmsh1df53eecce6aa75p169774jsn8123550febb4")
                .header("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String resultBody = response.body();

        assert resultBody != null;
        model.addAttribute("data", resultBody);
        return "nbaTeams";
    }
}
