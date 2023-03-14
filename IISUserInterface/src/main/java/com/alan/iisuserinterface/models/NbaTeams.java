package com.alan.iisuserinterface.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NbaTeams {
    @JsonProperty("team")
    private List<Team> team;

    @Override
    public String toString() {
        return "NbaTeams{" +
                "team=" + team +
                '}';
    }
}
