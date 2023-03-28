package com.alan.iisuserinterface.services;

import com.alan.iisuserinterface.clients.TeamsClient;
import com.alan.soap.nba.GetTeamResponse;
import com.alan.soap.nba.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SoapService {
    private final TeamsClient teamsClient;
    @Autowired
    public SoapService(TeamsClient teamsClient) {
        this.teamsClient = teamsClient;
    }

    public Optional<Team> findTeamByCode(String teamCode){
        GetTeamResponse teamByCode = teamsClient.getTeamByCode(teamCode);
        if (teamByCode.getTeam().getName() == null){
            return Optional.empty();
        }
        return Optional.ofNullable(teamByCode.getTeam());
    }
}
