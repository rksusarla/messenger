package com.artilekt.messenger.endpoints.v3;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.artilekt.messenger.domain.Message;
import com.artilekt.messenger.endpoints.MessageNotFoundException;

import java.util.*;

/**
 * Created by volen on 2017-06-29.
 */
@RestController
@RequestMapping("/v3/messages")
public class MessageService {
    private List<Message> messages = new ArrayList<>();

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }


    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message getMessage(@PathVariable UUID id) {
        Message msg = messages.stream().filter(el -> el.getId().equals(id)).findFirst().get();
        if (msg == null)   throw new MessageNotFoundException("Can't retrieve message. Message with id '"+id+"' not found");
        return msg;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message recordMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message updateMessage(@RequestBody Message message, @PathVariable UUID id) {
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
        Iterator<Message> iter = messages.iterator();
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
