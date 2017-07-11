package com.kafka;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class PlainLoginModule implements LoginModule {

//    private static final String USERNAME_CONFIG = "username";
//    private static final String PASSWORD_CONFIG = "password";
//
    private static final String USERNAME_CONFIG = "admin";
    private static final String PASSWORD_CONFIG = "admin-secret";

    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        System.out.println("----------------------------------Working-----------------------------");

        String username = (String) options.get(USERNAME_CONFIG);
        if (username != null)
            subject.getPublicCredentials().add(username);
        String password = (String) options.get(PASSWORD_CONFIG);
        if (password != null)
            subject.getPrivateCredentials().add(password);
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