package com.alan.xsdrestapi.service;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class NbaTeamsXSDService {
    public String validateXSD() {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xmlSchema = factory.newSchema(new File("xml/ApiNba.xsd"));
            Validator validator = xmlSchema.newValidator();
            File xml = new File("xml/ApiNba.xml");
            validator.validate(new StreamSource(xml));

            return Files.readString(Paths.get("xml/ApiNba.xml"));

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
