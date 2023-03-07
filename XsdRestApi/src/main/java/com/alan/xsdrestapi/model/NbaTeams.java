package com.alan.xsdrestapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "nbaTeams")
public class NbaTeams {
    @JsonProperty("team")
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
