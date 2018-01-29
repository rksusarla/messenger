package com.artilekt.messenger.domain;

/**
 * Created by volen on 2017-06-30.
 */
public class PrivateMessage extends Message {
    private User toUser;
    private User fromUser;

    public PrivateMessage(String content) {
        super(content);
    }

    public PrivateMessage() {
    }


    public User getToUser() {
        return toUser;
    }
/*

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
*/

    public User getFromUser() {
        return fromUser;
    }

/*
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
*/
}
