package com.example.lib;

import javax.json.JsonObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
public class App 
{

    public String getJson(String url) {
        Client client = ClientBuilder.newClient();
        Response response = client.target( url )
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        if (response.getStatus() != 200) {
            System.exit(1);
        }
        return response.readEntity( JsonObject.class ).toString();
    }

    public static void main( String[] args )
    {
        System.out.println(new App().getJson(args[0]));
    }
}
