package com.alan;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws IOException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:8080"));
        config.setEnabledForExceptions(true);
        config.setContentLengthOptional(false);
        config.setEnabledForExtensions(true);

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String finished;
        do {
            System.out.println("Unesi ime grada:");
            String city = reader.readLine();
            Object[] parameters = new Object[]{city};

            System.out.println(client.execute("XMLParser.parse", parameters));

            System.out.println("Zelite li nastaviti \nD : N");
            finished = reader.readLine();
        } while ("D".equals(finished));
    }
}
