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
    public static final String X_RAPID_API_KEY = "X-RapidAPI-Key";
    public static final String API_KEY = "388c8cc2dbmsh1df53eecce6aa75p169774jsn8123550febb4";
    public static final String X_RAPID_API_HOST = "X-RapidAPI-Host";
    public static final String HOST = "api-nba-v1.p.rapidapi.com";
    public static final String GET = "GET";

    @GetMapping
    public String getNbaTeams(Model model){
        return "nbaTeams";
    }

    @PostMapping("getData")
    public String getData(String data, Model model){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header(X_RAPID_API_KEY, API_KEY)
                    .header(X_RAPID_API_HOST, HOST)
                    .method(GET, HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = null;

            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String resultBody = response.body();

            assert resultBody != null;
            model.addAttribute("data", resultBody);
            return "nbaTeams";
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
