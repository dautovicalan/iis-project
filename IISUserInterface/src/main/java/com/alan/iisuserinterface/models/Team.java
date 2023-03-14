package com.alan.iisuserinterface.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @JsonProperty
    private Integer id;
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String nickname;
    @JsonProperty(required = true)
    private String code;
    @JsonProperty(required = true)
    private String city;
    @JsonProperty(required = true)
    private String logo;
    @JsonProperty(required = true)
    private boolean nbaFranchise;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", logo='" + logo + '\'' +
                ", nbaFranchise=" + nbaFranchise +
                '}';
    }
}
