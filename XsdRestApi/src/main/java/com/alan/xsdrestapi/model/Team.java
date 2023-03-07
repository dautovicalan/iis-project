package com.alan.xsdrestapi.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
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

    public Team(Integer id, String name, String nickname, String code, String city, String logo, boolean nbaFranchise) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.code = code;
        this.city = city;
        this.logo = logo;
        this.nbaFranchise = nbaFranchise;
    }
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
