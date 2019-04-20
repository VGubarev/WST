package org.vladimirg.wst.lab5.standalone.exceptions.providers;


import org.vladimirg.wst.lab5.standalone.exceptions.DatabaseFailureException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DatabaseFailureExceptionMapper implements ExceptionMapper<DatabaseFailureException> {
    @Override
    public Response toResponse(DatabaseFailureException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                entity(e.toString()).
                type("text/plain").
                build();
    }
}
