package org.vladimirg.wst.lab2;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {
    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "filter") FieldFilter filter) {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        try {
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            return db.getInstruments(instrumentFields);
        } catch (UnknownFieldsException e) {
            e.printStackTrace();
        }
        return new ArrayList<Instrument>();
    }

    @WebMethod(operationName = "createInstrument")
    public Integer createInstrument(@WebParam(name = "instrument") FieldFilter instrument) {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        try {
            InstrumentFields instrumentFields = new InstrumentFields(instrument);
            return db.createInstrument(instrumentFields);
        } catch (UnknownFieldsException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @WebMethod(operationName = "updateInstrument")
    public OperationStatus updateInstrument(@WebParam(name = "filter") FieldFilter filter) {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        try {
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            return db.updateInstrument(instrumentFields);
        } catch (UnknownFieldsException e) {
            e.printStackTrace();
        }
        return new OperationStatus(false, "Failed");
    }

    @WebMethod(operationName = "deleteInstrument")
    public OperationStatus deleteInstrument(@WebParam(name = "filter") FieldFilter filter) {
        InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
        try {
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            return db.deleteInstrument(instrumentFields);
        } catch (UnknownFieldsException e) {
            e.printStackTrace();
        }
        return new OperationStatus(false, "Failed");
    }
}