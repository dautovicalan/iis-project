package com.alan.xsdrestapi.service;

import com.alan.xsdrestapi.model.NbaTeams;
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
public class NbaTeamsXSDService {
    public String validateXSD(NbaTeams teams) {
        try {
            System.out.println(teams);
            String fileName = "xml/ApiNbaTest.xml";
            JAXBUtils.save(teams, fileName);

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xmlSchema = factory.newSchema(new File("xml/ApiNba.xsd"));
            Validator validator = xmlSchema.newValidator();
            File xml = new File(fileName);
            validator.validate(new StreamSource(xml));

            return Files.readString(Paths.get(fileName));

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
