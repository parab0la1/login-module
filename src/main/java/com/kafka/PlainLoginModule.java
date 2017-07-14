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
    private static final String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4UUtSaTlRdGk2cHdzc2Q2bXRRa2ZjR19xWVRHNS1vSDV5NkJQdVRteWIwIn0.eyJqdGkiOiI0YTNhMGZhYS1kYzczLTRkOTQtOTVkMS01OWU4OWZkMmMyZjUiLCJleHAiOjE1MDg1OTY1NDcsIm5iZiI6MCwiaWF0IjoxNTAwMDQyOTQ3LCJpc3MiOiJodHRwOi8vMTMuNzQuMzYuMTk4OjgwODAvYXV0aC9yZWFsbXMvbWFzdGVyIiwiYXVkIjoiYWRtaW4tY2xpIiwic3ViIjoiNWNjZTQ0NDEtMDI4Yi00NTI1LTg0NTQtZmM5MjE2ZWYxOTcwIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYWRtaW4tY2xpIiwiYXV0aF90aW1lIjowLCJzZXNzaW9uX3N0YXRlIjoiMDI0NWZkODktMTA1Zi00ZWM3LTgyNDQtOGEwNmY5NzYwNjgzIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6W10sInJlc291cmNlX2FjY2VzcyI6e30sInByZWZlcnJlZF91c2VybmFtZSI6ImFkbWluIn0.QFAzdO2LVO7cI83s2nnE8dNlcNk50jqDPa36zaTyT-h4qTrSjhARotQe3B357L95b7NMBaV8v9yHK76ftPx9qWHkJQ4j8ghTPJKrrRD3IuyFvhKhMNhYW-jf_wvBl_Om4goZaE7sop1qizvHP1J6xaeHgCjcHuHprnLS9_NPHl9BX0cgSE_LPtjaOvEOC0iqeFwYFObbk3FwlZriA5sU6csWleTHyhUXXRJCcsFSoOjN2m3TqIdSsT7CfY5ZKGvdSx98tLA-JJrCNkukd92MFn4SuRQ0vCubbKPVMjKEm2YG4ZfaQG5dq1wzz_DVQp4DqLUGK9059RIiGvf4bifjmA";

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