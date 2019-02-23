package com.vladimirg.wst.lab1_server;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {
    @WebMethod(operationName = "getAllInstruments")
    public List<Instrument> getAllInstruments() throws SQLException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        return db.getAllInstruments();
    }

    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "id") Integer id,
                                           @WebParam(name = "MIC") String MIC,
                                           @WebParam(name = "ISIN") String ISIN,
                                           @WebParam(name = "validUntil") Date validUntil,
                                           @WebParam(name = "derivative") Boolean derivative) throws SQLException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        return db.getInstruments(id, MIC, ISIN, validUntil, derivative);
    }
}