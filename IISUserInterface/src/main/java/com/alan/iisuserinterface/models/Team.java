package com.alan.iisuserinterface.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private Integer id;
    private String name;
    private String nickname;
    private String code;
    private String city;
    private String logo;
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
