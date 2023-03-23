package com.alan.xsdrestapi.model;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name", "nickname", "code", "city", "logo", "nbaFranchise"})
public class Team {
    @XmlAttribute
    private Integer id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "nickname")
    private String nickname;
    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "logo")
    private String logo;
    @XmlElement(name = "nbaFranchise")
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
