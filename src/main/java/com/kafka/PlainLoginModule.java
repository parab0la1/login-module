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
//    private static final String ACCESS_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJBSkN6ZDVXQ0RHOTNaZmVhMUxjWS1HSkk4Sk9fV3EteVpTcmNGTml4bHpNIn0.eyJqdGkiOiJkZjVkMGE5YS1hMTY5LTRlZGUtOGI0Yi0zMzM4OTAwMDRmMjAiLCJleHAiOjE1ODY2MTEwNjQsIm5iZiI6MCwiaWF0IjoxNTAwMjk3NDY0LCJpc3MiOiJodHRwOi8vNTIuMTY5LjE4LjE5ODo4MDgwL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6ImFkbWluLWNsaSIsInN1YiI6ImQ4ZjA2NDc4LWI1MjUtNGY5Yi1hMjQ2LTg1YTYwZjhmNWM3OSIsInR5cCI6IkJlYXJlciIsImF6cCI6ImFkbWluLWNsaSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjMyYjYyZjlmLWY2ZTMtNGM3Ny1iYjUxLTRjMjBmOWNmMmU2ZiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOltdLCJyZXNvdXJjZV9hY2Nlc3MiOnt9LCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiJ9.LW0j7ctaCKTPn2SmOIr9D8fTK6XAwZFekQwoLJ6VSwikzCvOonRwgstGcGH4nu22YM1R6PVOivoGSFL-76dBpYa_MRwahxcHwXdfwzoS7Z22tGP5Nl8h1RmOSAVGbKZDsgkVLo4987f233fAV462bFPkQ0ri-_6WXmRAHRJLWYMKYl1-b5vDBCbHA6d9vaOPujZ_iKP7892cExVodWajxdTG4ORFeZxRab81ZeUotRmv0xnNI3cyv0XmGy9OLqyqbP2LuM7TZcCDqNL5ih4kxEKVHj0RSfPtIpIouJUxXo_hGHI6cybcCJ9St8gFYHw9M2GvjtOJ4ugdiPTRZaUkTQ";
    private String accessToken = "";
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
//        String username = (String) options.get(USERNAME_CONFIG);

        // Retrieve the access token from client from JAAS file
        accessToken = "";
        for (Map.Entry<String, ?> entry : options.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // Replace with current keycloak instance url
//        String url = "http://52.169.18.198:8080/auth/admin/realms/master/users";
//        try {
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            con.setRequestProperty("Authorization", "Bearer " + accessToken);
//
//            int responseCode = con.getResponseCode();
//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            //print result
//            System.out.println(response.toString());
//
//
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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