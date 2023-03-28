package com.alan;

import com.alan.parser.XMLParser;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws XmlRpcException, IOException {
        WebServer server = new WebServer(8084);

        XmlRpcServer xmlServer = server.getXmlRpcServer();
        PropertyHandlerMapping propertyHandlerMapping = new PropertyHandlerMapping();
        propertyHandlerMapping.addHandler("XMLParser", XMLParser.class);
        xmlServer.setHandlerMapping(propertyHandlerMapping);

        XmlRpcServerConfigImpl config = (XmlRpcServerConfigImpl) xmlServer.getConfig();
        config.setEnabledForExceptions(true);
        config.setContentLengthOptional(true);
        config.setEnabledForExtensions(true);

        System.out.println("Server starting...");
        server.start();
        System.out.println("Server started");
    }
}
