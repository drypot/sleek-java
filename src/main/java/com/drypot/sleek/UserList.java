package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class UserList {
    Map<String, User> users;

    public UserList() {
        users = new HashMap<String, User>();
    }

    public void put(User u) {
        users.put(u.getName(), u);
    }

    public User get(String name) {
        return users.get(name);
    }

    public static UserList from(JsonNode usersNode) {
        UserList l = new UserList();
        for(JsonNode node : usersNode) {
            JsonNode admin = node.get("admin");
            l.put(new User(
                node.get("name").asText(),
                node.get("hash").asText(),
                admin != null ? admin.asBoolean() : false
            ));
        }
        return l;
    }
}
