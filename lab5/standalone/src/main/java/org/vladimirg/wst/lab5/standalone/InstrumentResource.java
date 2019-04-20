package org.vladimirg.wst.lab5.standalone;

import org.vladimirg.wst.lab5.client.Instrument;
import org.vladimirg.wst.lab5.client.OperationStatus;
import org.vladimirg.wst.lab5.standalone.exceptions.DatabaseFailureException;
import org.vladimirg.wst.lab5.standalone.exceptions.IllegalArgumentException;
import org.vladimirg.wst.lab5.standalone.exceptions.UnknownFieldsException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/instruments")
@Produces(MediaType.APPLICATION_JSON)
public class InstrumentResource {
    @GET
    public List<Instrument> getInstruments(@QueryParam("filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.getInstruments(instrumentFields);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createInstrument(Instrument instrument) throws DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        return db.createInstrument(instrument).toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public OperationStatus updateInstrument(Instrument instrument) throws DatabaseFailureException, IllegalArgumentException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        return db.updateInstrument(instrument);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public OperationStatus deleteInstrument(Instrument instrument) throws DatabaseFailureException, IllegalArgumentException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        return db.deleteInstrument(instrument);
    }
}