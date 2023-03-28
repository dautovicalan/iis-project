package com.alan.iisuserinterface.clients;

import com.alan.soap.nba.GetTeamRequest;
import com.alan.soap.nba.GetTeamResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TeamsClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TeamsClient.class);
    public static final String URL_SOAP = "http://localhost:8082/ws";
    private static final String CALLBACK = "http://www.alan.com/soap/nba/GetTeamRequest";

    public GetTeamResponse getTeamByCode(String teamCode){
        GetTeamRequest request = new GetTeamRequest();
        request.setTeamCode(teamCode);

        log.info("Requesting team for " + teamCode);

        return (GetTeamResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URL_SOAP, request,
                        new SoapActionCallback(
                                CALLBACK
                        ));
    }
}
