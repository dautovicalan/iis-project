package com.alan.xsdrestapi.service;

import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class NbaTeamsRNGService {
    public String validateRng() {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
            Schema xmlSchema = factory.newSchema(new File("xml/ApiNba.rng"));
            Validator validator = xmlSchema.newValidator();
            validator.validate(new StreamSource(new File("xml/ApiNba.xml")));

            return Files.readString(Paths.get("xml/ApiNba.xml"));

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
