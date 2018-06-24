package com.artilekt.messenger.endpoints.v4;


import com.artilekt.messenger.domain.PrivateMessage;
import com.artilekt.messenger.endpoints.MessageNotFoundException;
import com.artilekt.messenger.repositories.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v4/messages")
public class MessengerEndpoint {
    @Autowired
    private MessageDAO messageDAO;

    @GetMapping
    public List<PrivateMessage> getMessages() {
        return messageDAO.getAllMessages();
    }


    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage getMessage(@PathVariable UUID id) {
        return messageDAO.findMessageById(id);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage recordMessage(@RequestBody PrivateMessage message) {
        messageDAO.saveMessage(message);
        return message;
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage updateMessage(@RequestBody PrivateMessage message, @PathVariable UUID id) {
        return messageDAO.updateMessage(id, message);
    }


    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage deleteMessage(@PathVariable UUID id) {

        throw new MessageNotFoundException("Can't delete message. Message with id '"+id+"' not found");
    }

}
