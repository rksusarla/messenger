package com.artilekt.messenger.repositories;

import com.artilekt.messenger.domain.PrivateMessage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MessageDAO {
    public List<PrivateMessage> getAllMessages() {
        return null;
    }

    public PrivateMessage findMessageById(UUID id) {
        return null;
    }

    public void saveMessage(PrivateMessage message) {

    }

    public PrivateMessage updateMessage(UUID id, PrivateMessage message) {
        return null;
    }
}
