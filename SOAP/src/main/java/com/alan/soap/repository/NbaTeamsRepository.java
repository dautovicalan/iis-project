package com.alan.soap.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.alan.soap.nba.*;

import java.util.*;

@Component
public class NbaTeamsRepository {
    private static final HashMap<String, Team> nbaTeams = new HashMap<>();

    @PostConstruct
    public void initData(){
        Team team = new Team();
        team.setName("Milwaukee Bucks");
        team.setNickname("Bucks");
        team.setCode("MIB");
        team.setCity("Milwaukee");
        team.setLogo("Logo Team");
        team.setNbaFranchise(true);

        Team teamTwo = new Team();

        teamTwo.setName("Los Angeles Lakers");
        teamTwo.setNickname("Lakers");
        teamTwo.setCode("LAK");
        teamTwo.setCity("Los Angeles");
        teamTwo.setLogo("Team");
        teamTwo.setNbaFranchise(true);

        nbaTeams.put(team.getCode() ,team);
        nbaTeams.put(teamTwo.getCode(), teamTwo);
    }

    public Team findTeam(String teamCode){
        Assert.notNull(teamCode, "The team code cannot be null");
        return nbaTeams.get(teamCode);
    }
}
