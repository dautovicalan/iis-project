package com.alan.xsdrestapi.service;

import com.alan.xsdrestapi.XsdRestApiApplication;
import com.alan.xsdrestapi.model.NbaTeams;
import com.alan.xsdrestapi.utils.JAXBUtils;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

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

    // Solution : https://stackoverflow.com/questions/1541253/how-to-validate-an-xml-document-using-a-relax-ng-schema-and-jaxp
    private static final String RNG_SCHEMA_PATH = "xml/ApiNba.rng";
    public String validateRng(NbaTeams teams) {
        try {

            JAXBUtils.save(teams, XsdRestApiApplication.XML_FILE_NAME);

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
