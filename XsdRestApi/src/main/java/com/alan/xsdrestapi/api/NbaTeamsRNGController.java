package com.alan.xsdrestapi.api;

import com.alan.xsdrestapi.model.NbaTeams;
import com.alan.xsdrestapi.service.NbaTeamsRNGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nbateams/rng")
public class NbaTeamsRNGController {
    private final NbaTeamsRNGService nbaTeamsRNGService;

    @Autowired
    public NbaTeamsRNGController(NbaTeamsRNGService nbaTeamsRNGService) {
        this.nbaTeamsRNGService = nbaTeamsRNGService;
    }

    @PostMapping
    public String validateRng(@RequestBody NbaTeams nbaTeams){
        return nbaTeamsRNGService.validateRng(nbaTeams);
    }
}
