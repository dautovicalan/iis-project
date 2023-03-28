package com.alan.factory;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;

public final class StaxParserFactory {
    private StaxParserFactory(){

    }

    public static XMLEventReader createStaxParser(InputStream is) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        return factory.createXMLEventReader(is);
    }
}
