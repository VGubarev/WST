package org.vladimirg.wst.lab4.j2ee;

import org.vladimirg.wst.lab4.j2ee.Instrument;
import org.vladimirg.wst.lab4.j2ee.exceptions.DatabaseFailureException;
import org.vladimirg.wst.lab4.j2ee.exceptions.UnknownFieldsException;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Path("/instruments")
@Produces({MediaType.APPLICATION_JSON})

public class InstrumentResource {

    @Resource(lookup = "jdbc/itmo-ws")
    private DataSource dataSource;


    @GET
    public List<Instrument> getPersons(@QueryParam("filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.getInstruments(instrumentFields);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InstrumentResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}