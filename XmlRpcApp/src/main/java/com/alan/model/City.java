package com.alan.model;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class City {
    @XmlElement(name = "GradIme")
    private String cityName;
    @XmlElement(name = "Temp")
    private String temp;
    @XmlElement(name = "Vlaga")
    private String moisture;
    @XmlElement(name = "Tlak")
    private String pressure;
    @XmlElement(name = "VjetarSmjer")
    private String windDirection;
    @XmlElement(name = "VjetarBrzina")
    private String windSpeed;
    @XmlElement(name = "Vrijeme")
    private String weather;

    public City(String cityName, String temp, String moisture, String pressure, String windDirection, String windSpeed, String weather) {
        this.cityName = cityName;
        this.temp = temp;
        this.moisture = moisture;
        this.pressure = pressure;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", temp=" + temp +
                ", moisture=" + moisture +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeed=" + windSpeed +
                ", weather='" + weather + '\'' +
                '}';
    }
}
