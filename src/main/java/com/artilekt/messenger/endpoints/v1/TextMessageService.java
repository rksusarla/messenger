package com.artilekt.messenger.endpoints.v1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(method=RequestMethod.GET)
    public List<String> getMessages() {
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
