package com.alan.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public final class JAXBUtils {
    private JAXBUtils() {
    }
    public static void save(Object object, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(filename));
    }

    public static final String XSD_SCHEMA_PATH = "xml/ApiNba.xsd";

    public static Object loadAndValidateXml(Class clazz, String filename) throws JAXBException, SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema nbaSchema = schemaFactory.newSchema(new File(XSD_SCHEMA_PATH));
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(nbaSchema);
        return unmarshaller.unmarshal(new File(filename));
    }
}
