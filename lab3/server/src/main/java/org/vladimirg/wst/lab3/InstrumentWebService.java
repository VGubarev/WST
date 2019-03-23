package org.vladimirg.wst.lab3;

import org.vladimirg.wst.lab3.exceptions.DatabaseFailureException;
import org.vladimirg.wst.lab3.exceptions.IllegalArgumentException;
import org.vladimirg.wst.lab3.exceptions.UnknownFieldsException;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {
    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.getInstruments(instrumentFields);
    }

    @WebMethod(operationName = "createInstrument")
    public Integer createInstrument(@WebParam(name = "instrument") FieldFilter instrument) throws UnknownFieldsException, DatabaseFailureException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(instrument);
        return db.createInstrument(instrumentFields);
    }

    @WebMethod(operationName = "updateInstrument")
    public OperationStatus updateInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.updateInstrument(instrumentFields);
    }

    @WebMethod(operationName = "deleteInstrument")
    public OperationStatus deleteInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        InstrumentFields instrumentFields = new InstrumentFields(filter);
        return db.deleteInstrument(instrumentFields);
    }
}