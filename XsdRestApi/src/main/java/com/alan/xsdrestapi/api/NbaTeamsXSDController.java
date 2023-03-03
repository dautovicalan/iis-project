package com.alan.xsdrestapi.api;

import com.alan.xsdrestapi.service.NbaTeamsXSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nbateams/xsd")
public class NbaTeamsXSDController {
    private final NbaTeamsXSDService nbaTeamsXSDService;

    @Autowired
    public NbaTeamsXSDController(NbaTeamsXSDService nbaTeamsXSDService) {
        this.nbaTeamsXSDService = nbaTeamsXSDService;
    }

    @PostMapping
    public String validateXSD(){
        return nbaTeamsXSDService.validateXSD();
    }
}
