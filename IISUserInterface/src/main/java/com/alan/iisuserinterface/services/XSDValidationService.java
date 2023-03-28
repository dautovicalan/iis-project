package com.alan.iisuserinterface.services;

import com.alan.iisuserinterface.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class XSDValidationService {

    private static final String API_URL = "http://localhost:5001/api/v1/nbateams/xsd";
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    @Autowired
    public XSDValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    public String testXsdValidation(Team team){
        HttpEntity<Team> request = new HttpEntity<>(team, httpHeaders);
        ResponseEntity<String> result = restTemplate.postForEntity(API_URL, request, String.class);

        return result.getBody();
    }
}
