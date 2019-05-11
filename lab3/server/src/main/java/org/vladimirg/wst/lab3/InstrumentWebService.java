package org.vladimirg.wst.lab3;

import org.vladimirg.wst.lab3.exceptions.*;
import org.vladimirg.wst.lab3.exceptions.IllegalArgumentException;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName = "InstrumentService")
public class InstrumentWebService {

    @Resource
    WebServiceContext wsctx;

    ThrottleService throttle = new ThrottleService(1);

    void check_auth() throws AuthenticationException {
        MessageContext mctx = wsctx.getMessageContext();

        //get detail from request headers
        Map<String, Object> http_headers = (Map<String, Object>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> credentials = (List<String>) http_headers.get("Authorization");

        if (credentials == null ||
            credentials.isEmpty() ||
            !(new String(Base64.getDecoder().decode(credentials.get(0)))).equals("admin:admin")) {
            throw new AuthenticationException("Invalid credentials", InstrumentServiceFault.defaultInstance());
        }
    }

    @WebMethod(operationName = "getInstruments")
    public List<Instrument> getInstruments(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, ThrottleException, AuthenticationException {
        check_auth();
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
    public Integer createInstrument(@WebParam(name = "instrument") FieldFilter instrument) throws UnknownFieldsException, DatabaseFailureException, ThrottleException, AuthenticationException {
        check_auth();
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
    public OperationStatus updateInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException, ThrottleException, AuthenticationException {
        check_auth();
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
    public OperationStatus deleteInstrument(@WebParam(name = "filter") FieldFilter filter) throws UnknownFieldsException, DatabaseFailureException, IllegalArgumentException, ThrottleException, AuthenticationException {
        check_auth();
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