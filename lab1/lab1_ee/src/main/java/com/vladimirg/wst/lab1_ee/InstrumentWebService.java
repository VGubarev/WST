package com.vladimirg.wst.lab1_ee;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {
    @Resource(lookup = "jdbc/itmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "getAllInstruments")
    public List<Instrument> getAllInstruments() throws SQLException {
        InstrumentDB db = new InstrumentDB(getConnection());
        return db.getAllInstruments();
    }

    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "id") Integer id,
                                           @WebParam(name = "MIC") String MIC,
                                           @WebParam(name = "ISIN") String ISIN,
                                           @WebParam(name = "validUntil") Date validUntil,
                                           @WebParam(name = "derivative") Boolean derivative) throws SQLException {
        InstrumentDB db = new InstrumentDB(getConnection());
        return db.getInstruments(id, MIC, ISIN, validUntil, derivative);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InstrumentWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}