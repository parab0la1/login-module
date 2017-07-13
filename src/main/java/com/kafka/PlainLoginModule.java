package com.kafka;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

public class PlainLoginModule implements LoginModule {

    private static final String USERNAME_CONFIG = "username";
    private static final String PASSWORD_CONFIG = "password";

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        System.out.println("----------------------------------Working1-----------------------------");
        String username = (String) options.get(USERNAME_CONFIG);

        for (Map.Entry<String, ?> value : options.entrySet()) {
            System.out.println(value.getKey());
            System.out.println(value.getValue());
        }

        if (username != null)
            System.out.println("----------------------------------Working2-----------------------------");
        subject.getPublicCredentials().add(username);
        String password = (String) options.get(PASSWORD_CONFIG);
        if (password != null)
            System.out.println("----------------------------------Working3-----------------------------");
        subject.getPrivateCredentials().add(password);
        System.out.println("----------------------------------Working4-----------------------------");
    }

    @Override
    public boolean login() throws LoginException {
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }
}