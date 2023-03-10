package com.alan.xsdrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

@SpringBootApplication
public class XsdRestApiApplication {

    public static final String XML_FILE_NAME = "xml/ApiNbaTest.xml";
    public static void main(String[] args) {
        System.setProperty(SchemaFactory.class.getName() + ":" + XMLConstants.RELAXNG_NS_URI, "com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory");
        SpringApplication.run(XsdRestApiApplication.class, args);
    }
}
