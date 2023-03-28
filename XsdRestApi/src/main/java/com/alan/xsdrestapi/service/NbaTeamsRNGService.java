package com.alan.xsdrestapi.service;

import com.alan.xsdrestapi.XsdRestApiApplication;
import com.alan.xsdrestapi.model.Team;
import com.alan.xsdrestapi.utils.JAXBUtils;
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

    private static final String RNG_SCHEMA_PATH = "xml/ApiNba.rng";
    public String validateRng(Team team) {
        try {

            JAXBUtils.save(team, XsdRestApiApplication.XML_FILE_NAME);

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.RELAXNG_NS_URI);
            Schema xmlSchema = factory.newSchema(new File(RNG_SCHEMA_PATH));
            Validator validator = xmlSchema.newValidator();
            File xml = new File(XsdRestApiApplication.XML_FILE_NAME);
            validator.validate(new StreamSource(xml));

            return Files.readString(Paths.get(XsdRestApiApplication.XML_FILE_NAME));

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
