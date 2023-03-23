package com.alan.soap;

import com.alan.soap.nba.GetTeamRequest;
import com.alan.soap.nba.GetTeamResponse;
import com.alan.soap.repository.NbaTeamsRepository;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@WebService
public class NbaTeamsEndpoint {

    private static final String NAMESPACE_URI = "http://www.alan.com/soap/nba";
    private final NbaTeamsRepository nbaTeamsRepository;

    @Autowired
    public NbaTeamsEndpoint(NbaTeamsRepository nbaTeamsRepository) {
        this.nbaTeamsRepository = nbaTeamsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTeamRequest")
    @ResponsePayload
    public GetTeamResponse getTeam(@RequestPayload GetTeamRequest request){
        GetTeamResponse response = new GetTeamResponse();
        response.setTeam(nbaTeamsRepository.findTeam(request.getTeamCode()));

        return response;
    }
}
