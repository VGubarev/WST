package org.vladimirg.wst.lab3;

import org.vladimirg.wst.lab3.exceptions.*;
import org.vladimirg.wst.lab3.exceptions.IllegalArgumentException;

import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {
    ThrottleService throttle = new ThrottleService(0);

    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, ThrottleException {
        throttle.acquire();
        try {
            InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            List<Instrument> list = db.getInstruments(instrumentFields);
            return list;
        }
        finally {
            throttle.release();
        }
    }

    @WebMethod(operationName = "createInstrument")
    public Integer createInstrument(@WebParam(name = "instrument") FieldFilter instrument) throws UnknownFieldsException, DatabaseFailureException, ThrottleException {
        throttle.acquire();
        try {
            InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
            InstrumentFields instrumentFields = new InstrumentFields(instrument);
            Integer id = db.createInstrument(instrumentFields);
            return id;
        }
        finally {
            throttle.release();
        }
    }

    @WebMethod(operationName = "updateInstrument")
    public OperationStatus updateInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException, ThrottleException {
        throttle.acquire();
        try {
            InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            OperationStatus status = db.updateInstrument(instrumentFields);
            return status;
        }
        finally {
            throttle.release();
        }
    }

    @WebMethod(operationName = "deleteInstrument")
    public OperationStatus deleteInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException, ThrottleException {
        throttle.acquire();
        try {
            InstrumentDB db = new InstrumentDB(ConnectionUtil.getConnection());
            InstrumentFields instrumentFields = new InstrumentFields(filter);
            OperationStatus status = db.deleteInstrument(instrumentFields);
            return status;
        }
        finally {
            throttle.release();
        }
    }
}