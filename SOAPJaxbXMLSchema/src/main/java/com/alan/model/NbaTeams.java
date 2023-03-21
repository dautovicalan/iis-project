package com.alan.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "nbaTeams")
public class NbaTeams {
    private List<Team> team;

    public NbaTeams(List<Team> team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "NbaTeams{" +
                "team=" + team +
                '}';
    }
}
