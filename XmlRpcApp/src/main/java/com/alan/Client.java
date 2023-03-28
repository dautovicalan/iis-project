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

    private static final String RPC_SERVER_URL = "http://localhost:8084";

    public static void main(String[] args) throws IOException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL(RPC_SERVER_URL));
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
            System.out.println("Enter city name:");
            String city = reader.readLine();
            Object[] parameters = new Object[]{city};

            System.out.println(client.execute("XMLParser.parse", parameters));

            System.out.println("Do you wanna continue ? \nY : N");
            finished = reader.readLine();
        } while ("Y".equalsIgnoreCase(finished));
    }
}
