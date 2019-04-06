package org.vladimirg.wst.lab4.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;

public class ClientApp {
    static String URL = "http://0.0.0.0:8080/rest/instruments";

    public static void main(String[] args)
    {
        Client client = Client.create();
        printList(getAllPersons(client, "ID=1"));
        System.out.println();
        printList(getAllPersons(client, "derivative=true"));
    }

    private static List<Instrument> getAllPersons(Client client, String filter) {
        WebResource webResource = client.resource(URL);
        if (filter != null) {
            webResource = webResource.queryParam("filter", filter);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Instrument>> type = new GenericType<List<Instrument>>() {};
        return response.getEntity(type);
    }

    private static void printList(List<Instrument> persons) {
        for (Instrument person : persons) {
            System.out.println(person);
        }
    }
}