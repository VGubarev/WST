package org.vladimirg.wst.lab5.standalone;

import com.sun.jersey.core.util.Base64;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private static Map<String, String> passwordStorage = new HashMap<String, String>() {{
        put("admin", "admin");
    }};

    public static boolean authenticate(String encoded) {
        if (encoded == null) {
            return false;
        }

        String usernameAndPassword = Base64.base64Decode(encoded.replaceFirst("Basic ", ""));
        String authValue[] = usernameAndPassword.split(":");
        String login = authValue[0];
        String password = authValue[1];

        if ((login == null) || login.isEmpty())
        {
            return false;
        }

        String correctPassword = passwordStorage.get(login);
        if ((correctPassword != null) && correctPassword.equals(password)) {
            return true;
        }
        else return false;
    }
}