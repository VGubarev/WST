package org.vladimirg.wst.lab5.standalone.exceptions.providers;

import org.vladimirg.wst.lab5.standalone.exceptions.UnknownFieldsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnknownFieldsExceptionMapper implements ExceptionMapper<UnknownFieldsException> {
    @Override
    public Response toResponse(UnknownFieldsException e) {
        return Response.status(Response.Status.BAD_REQUEST).
                entity(e.toString()).
                type("text/plain").
                build();
    }
}
