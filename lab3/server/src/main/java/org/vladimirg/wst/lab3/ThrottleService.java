package org.vladimirg.wst.lab3;

import org.vladimirg.wst.lab3.exceptions.InstrumentServiceFault;
import org.vladimirg.wst.lab3.exceptions.ThrottleException;

public class ThrottleService {
    int capacity = 0;
    int value = 0;

    public ThrottleService(int capacity) {
        this.capacity = capacity;
    }

    synchronized void acquire() throws ThrottleException
    {
        if (value == capacity) {
            InstrumentServiceFault fault = InstrumentServiceFault.defaultInstance();
            throw new ThrottleException("Paralell request limit is exceeded", fault);
        }
        value++;
    }

    synchronized void release()
    {
        value--;
    }
}
