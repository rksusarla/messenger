package com.artilekt.messenger.endpoints.v3;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.artilekt.messenger.domain.Message;
import com.artilekt.messenger.domain.PrivateMessage;
import com.artilekt.messenger.endpoints.MessageNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by volen on 2017-06-30.
 */
@RestController
@RequestMapping("/v3/messages/private")
public class PrivateMessageService {
    private List<PrivateMessage> messages = new ArrayList<>();

    @GetMapping
    public List<PrivateMessage> getMessages() {
        return messages;
    }


    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage getMessage(@PathVariable UUID id) {
        PrivateMessage msg = messages.stream().filter(el -> el.getId().equals(id)).findFirst().get();
        if (msg == null)   throw new MessageNotFoundException("Can't retrieve message. Message with id '"+id+"' not found");
        return msg;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage recordMessage(@RequestBody PrivateMessage message) {
        messages.add(message);
        return message;
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PrivateMessage updateMessage(@RequestBody PrivateMessage message, @PathVariable UUID id) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId().equals(id)) {
                messages.set(i, message);
                return message;
            }
        }
        throw new MessageNotFoundException("Can't update message. Message with id '"+id+"' not found");
    }


    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message deleteMessage(@PathVariable UUID id) {
        Iterator<PrivateMessage> iter = messages.iterator();
        while (iter.hasNext()) {
            Message msg = iter.next();
            if (msg.getId().equals(id)) {
                iter.remove();
                return msg;
            }
        }
        throw new MessageNotFoundException("Can't delete message. Message with id '"+id+"' not found");
    }

}
