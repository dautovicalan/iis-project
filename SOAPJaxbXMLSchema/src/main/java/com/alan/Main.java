package com.alan;

import com.alan.soap.EntitySearch;
import com.alan.soap.EntitySearchImplementation;
import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        EntitySearch entitySearch = new EntitySearchImplementation();
        String endpoint = "http://localhost:8080/NbaTeams";
        Endpoint.publish(endpoint, entitySearch);
        System.out.println("Endpoint published at " + endpoint);
    }
}