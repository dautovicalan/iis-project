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
    private Double temp;
    @XmlElement(name = "Vlaga")
    private Double moisture;
    @XmlElement(name = "Tlak")
    private Double pressure;
    @XmlElement(name = "VjetarSmjer")
    private String windDirection;
    @XmlElement(name = "VjetarBrzina")
    private Double windSpeed;
    @XmlElement(name = "Vrijeme")
    private String weather;

    public City(String cityName, Double temp, Double moisture, Double pressure, String windDirection, Double windSpeed, String weather) {
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
