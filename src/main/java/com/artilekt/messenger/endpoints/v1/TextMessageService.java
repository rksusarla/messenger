package com.artilekt.messenger.endpoints.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.artilekt.messenger.services.AuditService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by volen on 2017-06-29.
 */
@RestController
@RequestMapping("/v1/messages")
public class TextMessageService {
    private List<String> messages = new ArrayList<>();
    
    @Autowired
    @Qualifier("defaultAuditService")
    private AuditService auditService;

    @RequestMapping(method=RequestMethod.GET)
    public List<String> getMessages() {
    	auditService.createLogEntry("all messages are retrieved");
        return messages;
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String getMessage(@PathVariable int id) {
        return messages.get(id);
    }


    @RequestMapping(method=RequestMethod.POST)
    public int recordMessage(@RequestBody String message) {
        messages.add(message);
        return messages.size()-1;
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public int updateMessage(@RequestBody String message, @PathVariable int id) {
        messages.set(id, message);
        return id;
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteMessage(@PathVariable int id) {
        return messages.remove(id);
    }

}
