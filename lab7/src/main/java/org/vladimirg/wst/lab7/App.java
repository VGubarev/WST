package org.vladimirg.wst.lab7;


import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        JUDDIConnector juddiClient = new JUDDIConnector("META-INF/uddi_config.xml");
        String businessKey = null;
        String serviceKey = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please, select the type of action: register / call / exit");
            try {
                String actionType = br.readLine();
                try {
                    switch (actionType) {
                        case "register":
                            String URL = "http://localhost:8081/InstrumentService";
                            Pair<String, String> keys = juddiClient.publish("Exchange", "Instrument Service", URL);
                            businessKey = keys.getLeft();
                            serviceKey = keys.getRight();
                            break;
                        case "call":
                            juddiClient.findAndCall(serviceKey);
                            break;
                        case "exit":
                            if (businessKey != null) {
                                juddiClient.removeBusiness(businessKey);
                            }
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Unsupported operation");
                            break;
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Received error: " + ex.getMessage());
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}