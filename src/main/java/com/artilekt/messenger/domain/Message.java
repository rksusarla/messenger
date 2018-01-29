package com.artilekt.messenger.domain;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by volen on 2017-06-29.
 */
public class Message {
    private final long   timestamp = System.currentTimeMillis();
    private final UUID   id        = UUID.randomUUID();
    private       String content;

    public Message(String content) { this.content = content; }
    public Message()               {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return id.equals(message.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

/*
    public void setContent(String content) {
        this.content = content;
    }
*/


}
