package com.alan.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapApplication {

    //curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

}
