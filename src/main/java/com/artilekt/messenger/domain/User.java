package com.artilekt.messenger.domain;

import java.util.UUID;

/**
 * Created by volen on 2017-06-30.
 */
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
