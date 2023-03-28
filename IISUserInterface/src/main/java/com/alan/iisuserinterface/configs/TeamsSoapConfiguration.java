package com.alan.iisuserinterface.configs;

import com.alan.iisuserinterface.clients.TeamsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TeamsSoapConfiguration {

    private static final String PACKAGE_NAME = "com.alan.soap.nba";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(PACKAGE_NAME);
        return marshaller;
    }

    @Bean
    public TeamsClient teamsClient(Jaxb2Marshaller marshaller) {
        TeamsClient client = new TeamsClient();
        client.setDefaultUri(TeamsClient.URL_SOAP);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
