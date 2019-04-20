package org.vladimirg.wst.lab5.standalone;

import java.util.*;

public class FieldFilter {
    public HashMap<String, String> fields;

    public FieldFilter()
    {
        fields = new HashMap<>();
    }

    public FieldFilter(String string)
    {
        fields = new HashMap<>();
        for (String field : string.split(",")) {
            String[] kv = field.split("=");
            if (kv.length != 2) {
                throw new IllegalArgumentException("Invalid field " + field);
            }
            fields.put(kv[0], kv[1]);
        }
    }

    public void put(String field, String value)
    {
        fields.put(field, value);
    }

    public String getField(String field)
    {
        return fields.get(field);
    }

    public boolean hasField(String field)
    {
        return fields.containsKey(field);
    }

    public List<String> validate(List<String> valid_fields)
    {
        List<String> unknown = new ArrayList<>();
        for (String field : fields.keySet()) {
            if (!valid_fields.contains(field)) {
                unknown.add(field);
            }
        }

        return unknown;
    }
}
