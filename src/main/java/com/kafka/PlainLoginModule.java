package com.kafka;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class PlainLoginModule implements LoginModule {

    private static final String USERNAME_CONFIG = "username";
    private static final String PASSWORD_CONFIG = "password";
    private static final String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4UUtSaTlRdGk2cHdzc2Q" +
            "2bXRRa2ZjR19xWVRHNS1vSDV5NkJQdVRteWIwIn0.eyJqdGkiOiJhMTM0OGEwNC1lYWU0LTQyYzEtODJmYi01YzU1NDM0ZWM2YjkiLCJle" +
            "HAiOjE1MDg1OTUwMTcsIm5iZiI6MCwiaWF0IjoxNTAwMDQxNDE3LCJpc3MiOiJodHRwOi8vMTMuNzQuMzYuMTk4OjgwODAvYXV0aC9yZWF" +
            "sbXMvbWFzdGVyIiwiYXVkIjoiYWRtaW4tY2xpIiwic3ViIjoiNWNjZTQ0NDEtMDI4Yi00NTI1LTg0NTQtZmM5MjE2ZWYxOTcwIiwidHlwI" +
            "joiQmVhcmVyIiwiYXpwIjoiYWRtaW4tY2xpIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiODliYWU1YmItMjM3NC00MzQ4LWF" +
            "iNjEtNGUyOTk2MmY2NThiIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6W10sInJlc291cmNlX2FjY2VzcyI6e30sInByZWZlcnJlZ" +
            "F91c2VybmFtZSI6ImFkbWluIn0.BmR97AB2C5mUBFCUQTodDtwtvmF-nA5FGPh32An5COU-x-0rs81EWzr8nWUiJCiR-GncUw6hYHmWjxA" +
            "8lvJ4Lj7O2dauwmBlT-fk28-nlPwwtLv4dvQ97LOMzUVHeuJSzrC4eXXF6qdLROB-M0NDkR-dY9hOdx8BxeKeVFsKKiJ-qf2vtAJqjoK-x" +
            "f48_xsNzUS9Y7eoA0V-baaFf_pzMyaJAENYHG9ZiwvEssM_BMTFAPcyabnIeJD8iR1s1fgdEo38APjM8x5nhswfqpJmpVJ-MARxJ177Z3w" +
            "zhU7v3MWB3MiWGgV-9NmGv2uqppYOhuEzbIBGDzUdhUoMjbKk2g";

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        System.out.println("Authenticated");


//        System.out.println("----------------------------------Working1-----------------------------");
//        String username = (String) options.get(USERNAME_CONFIG);
//
        for (Map.Entry<String, ?> value : options.entrySet()) {
            System.out.println(value.getKey());
            System.out.println(value.getValue());
        }

//        Keycloak keycloak = Keycloak.getInstance(
//            "13.74.36.198:8080",
//                "master",
//                "admin",
//                "admin",
//                "admin-cli"
//        );
//        RealmRepresentation realm = keycloak.realm("master").toRepresentation();
//        System.out.println(keycloak.realm("master"));
//        System.out.println(keycloak.serverInfo());


        String url = "http://13.74.36.198:8080/auth/admin/realms/master/users";
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestProperty("Authorization", "bearer " + ACCESS_TOKEN);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean login() throws LoginException {
        return true;
    }

    public boolean logout() throws LoginException {
        return true;
    }

    public boolean commit() throws LoginException {
        return true;
    }

    public boolean abort() throws LoginException {
        return false;
    }
}