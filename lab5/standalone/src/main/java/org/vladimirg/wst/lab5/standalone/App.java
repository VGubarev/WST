package org.vladimirg.wst.lab5.standalone;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;

public class App {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/rest";

        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new PackagesResourceConfig(InstrumentResource.class.getPackage().getName());
            resourceConfig.getProperties().put("com.sun.jersey.spi.container.ContainerRequestFilters", "org.vladimirg.wst.lab5.standalone.AuthenticationFilter");
            server = GrizzlyServerFactory.createHttpServer(url, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}