package com.alan.parser;

import com.alan.factory.StaxParserFactory;
import com.alan.factory.UrlConnectionFactory;
import com.alan.model.City;
import com.alan.model.TagType;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class XMLParser {

    private static final String RSS_URL = "https://vrijeme.hr/hrvatska_n.xml";

    public String parse(String cityName) throws IOException, XMLStreamException {
        List<City> cityList = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);

        try (InputStream is = con.getInputStream()) {
            XMLEventReader reader = StaxParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            City city = null;
            StartElement startElement;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        startElement = event.asStartElement();
                        String name = startElement.getName().getLocalPart();
                        tagType = TagType.from(name);
                        if (tagType.isPresent() && tagType.get() == TagType.CITY_NAME) {
                            city = new City();
                            cityList.add(city);
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        if (tagType.isPresent()) {
                            Characters characters = event.asCharacters();
                            String data = characters.getData().trim();
                            switch (tagType.get()) {

                                case CITY_NAME -> {
                                    if (!data.isEmpty()) {
                                        city.setCityName(data);
                                    }
                                }
                                case TEMPERATURE -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setTemp(data);
                                    }
                                }
                                case MOISTURE -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setMoisture(data);
                                    }
                                }
                                case PRESSURE -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setPressure(data);
                                    }
                                }
                                case WIND_DIRECTION -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setWindDirection(data);
                                    }
                                }
                                case WIND_SPEED -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setWindSpeed(data);
                                    }
                                }
                                case WEATHER -> {
                                    if (city != null && !data.isEmpty()) {
                                        city.setWeather(data);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (City element : cityList) {
            if (element.getCityName().equals(cityName)) {
                return element.toString();
            }
        }
        return cityName + " does not exist";
    }
}
