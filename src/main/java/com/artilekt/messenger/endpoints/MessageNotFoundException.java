package com.artilekt.messenger.endpoints;

/**
 * Created by volen on 2017-06-29.
 */
public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException() {
    }

    public MessageNotFoundException(String message) {
        super(message);
    }
}
