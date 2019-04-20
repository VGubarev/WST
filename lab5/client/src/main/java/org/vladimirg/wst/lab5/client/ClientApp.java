package org.vladimirg.wst.lab5.client;

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
        printList(getPersonsByFilter(client, "ID=1"));
        System.out.println();
        printList(getPersonsByFilter(client, "derivative=true"));
        System.out.println();


        try {
            System.out.println("Check invalid request");
            printList(getPersonsByFilter(client, "id=1"));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        Integer res = -1;
        System.out.println("Insert instrument");
        Instrument instrument = new Instrument();
        instrument.setDerivative(true);
        instrument.setISIN("FAFAFAF");
        instrument.setMIC("XHON");
        res = createInstrument(client, instrument);
        System.out.println("Inserted instrument with ID=" + res);
        printList(getPersonsByFilter(client, ""));

        System.out.println("Update instrument");
        updateInstrument(client, new Instrument().setId(res).setDerivative(true));

        printList(getPersonsByFilter(client, ""));

        System.out.println("Delete instrument");
        deleteInstrument(client, new Instrument().setId(res));

        printList(getPersonsByFilter(client, ""));
    }

    private static List<Instrument> getPersonsByFilter(Client client, String filter) throws IllegalStateException {
        WebResource webResource = client.resource(URL);
        if (filter != null) {
            webResource = webResource.queryParam("filter", filter);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException(response.getEntity(java.lang.String.class));
        }
        GenericType<List<Instrument>> type = new GenericType<List<Instrument>>() {};
        return response.getEntity(type);
    }

    private static Integer createInstrument(Client client, Instrument instrument) throws IllegalStateException {
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, instrument);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: " + response.toString());
        }

        return Integer.parseInt(response.getEntity(String.class));
    }

    private static OperationStatus updateInstrument(Client client, Instrument instrument) throws IllegalStateException {
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .put(ClientResponse.class, instrument);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: " + response.toString());
        }

        return response.getEntity(OperationStatus.class);
    }

    private static OperationStatus deleteInstrument(Client client, Instrument instrument) throws IllegalStateException {
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .delete(ClientResponse.class, instrument);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: " + response.toString());
        }

        return response.getEntity(OperationStatus.class);
    }

    private static void printList(List<Instrument> persons) {
        for (Instrument person : persons) {
            System.out.println(person);
        }
    }
}