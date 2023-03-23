package com.alan.soap.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.alan.soap.nba.*;
import utils.XMLUtils;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.math.BigInteger;
import java.util.*;

@Component
public class NbaTeamsRepository {
    private static final HashMap<String, Team> nbaTeams = new HashMap<>();

    @PostConstruct
    public void initData(){
        Team team = new Team();
        team.setId(new BigInteger("1"));
        team.setName("Milwaukee Bucks");
        team.setNickname("Bucks");
        team.setCode("MIB");
        team.setCity("Milwaukee");
        team.setLogo("Logo Team");
        team.setNbaFranchise(true);

        Team teamTwo = new Team();

        teamTwo.setId(new BigInteger("2"));
        teamTwo.setName("Los Angeles Lakers");
        teamTwo.setNickname("Lakers");
        teamTwo.setCode("LAK");
        teamTwo.setCity("Los Angeles");
        teamTwo.setLogo("Team");
        teamTwo.setNbaFranchise(true);

        Team teamThree = new Team();

        teamThree.setId(new BigInteger("3"));
        teamThree.setName("Chicago Bulls");
        teamThree.setNickname("Bulls");
        teamThree.setCode("CHB");
        teamThree.setCity("Chicago");
        teamThree.setLogo("Logo Bulls");
        teamThree.setNbaFranchise(true);

        nbaTeams.put(team.getCode() ,team);
        nbaTeams.put(teamTwo.getCode(), teamTwo);
        nbaTeams.put(teamThree.getCode(), teamThree);
    }

    public Team findTeam(String teamCode){
        try {
            Assert.notNull(teamCode, "The team code cannot be null");
            return XMLUtils.performXPathAndSaving(nbaTeams, teamCode);
        } catch (XPathExpressionException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
