package com.artilekt.messenger.endpoints.v2;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by volen on 2017-06-29.
 */
@RestController
@RequestMapping("/v2/messages")
public class SimpleMapMessageService {
    private List<String> messages = new ArrayList<>();

    @RequestMapping(method=RequestMethod.GET)
    public List<String> getMessages() {
        return messages;
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Map<Integer, String> getMessage(@PathVariable int id) {
        return toMap(messages, id);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, String> recordMessage(@RequestBody Map<String, String> request) {
        messages.add(request.get("message"));
        return toMap(messages, messages.size()-1);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public Map<Integer, String> updateMessage(@RequestBody String message, @PathVariable int id) {
        messages.set(id, message);
        return toMap(messages, id);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public Map<Integer, String> deleteMessage(@PathVariable int id) {
        Map<Integer, String> res = toMap(messages, id);
        messages.remove(id);
        return res;
    }


    //== support ==//
    private <E> Map<Integer, E> toMap(List<E> list) {
        Map<Integer, E> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++ ) {
            map.put(i, list.get(i));
        }
        return map;
    }

    private <E> Map<Integer, E> toMap(List<E> list, int index) {
        Map<Integer, E> map = new HashMap<>();
        map.put(index, list.get(index));
        return map;
    }
}
