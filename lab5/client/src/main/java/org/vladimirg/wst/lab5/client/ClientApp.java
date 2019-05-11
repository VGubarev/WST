package org.vladimirg.wst.lab5.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.impl.MultiPartWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javax.ws.rs.core.MediaType;

public class ClientApp {
    static String URL = "http://0.0.0.0:8080/rest/instruments";
    static String FILE_URL = "http://0.0.0.0:8080/rest/files/upload";

    public static void main(String[] args)
    {
        ClientConfig cc = new DefaultClientConfig();
        Client client = Client.create(cc);

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

        // upload file
        try {
            uploadFile(client, "/home/izoomko/wrk/5grade/ml.tasks");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    private static void uploadFile(Client client, String fileLocation) throws IllegalStateException, FileNotFoundException {
        FormDataMultiPart formPart = new FormDataMultiPart();
        formPart.bodyPart(new FormDataBodyPart(FormDataContentDisposition.name("file").fileName(new File(fileLocation).getName()).build(),
                new FileInputStream(fileLocation), MediaType.APPLICATION_OCTET_STREAM_TYPE));
        WebResource webResource = client.resource(FILE_URL);
        ClientResponse response = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
                .post(ClientResponse.class, formPart);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: " + response.toString());
        }

        System.out.println(response.getEntity(String.class));
    }

    private static void printList(List<Instrument> persons) {
        for (Instrument person : persons) {
            System.out.println(person);
        }
    }
}