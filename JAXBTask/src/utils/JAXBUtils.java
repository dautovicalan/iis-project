/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author alandautovic
 */
public final class JAXBUtils {
    
    private JAXBUtils(){
        
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
