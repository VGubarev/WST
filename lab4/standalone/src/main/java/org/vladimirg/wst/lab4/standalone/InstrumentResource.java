package org.vladimirg.wst.lab4.standalone;

import org.vladimirg.wst.lab4.client.Instrument;
import org.vladimirg.wst.lab4.standalone.exceptions.DatabaseFailureException;
import org.vladimirg.wst.lab4.standalone.exceptions.UnknownFieldsException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/instruments")
@Produces({MediaType.APPLICATION_JSON})

public class InstrumentResource {
    @GET
    public List<Instrument> getPersons(@QueryParam("filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.getInstruments(instrumentFields);
    }
}