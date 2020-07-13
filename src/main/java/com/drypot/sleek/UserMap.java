package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
    Map<String, User> users;

    public UserMap() {
        users = new HashMap<String, User>();
    }

    public void put(User u) {
        users.put(u.getName(), u);
    }

    public User get(String name) {
        return users.get(name);
    }

    public static UserMap from(JsonNode users) {
        UserMap l = new UserMap();
        for(JsonNode user : users) {
            JsonNode admin = user.get("admin");
            boolean isAdmin = admin == null ? false : admin.asBoolean();
            l.put(new User(
                user.get("name").asText(),
                user.get("hash").asText(),
                isAdmin
            ));
        }
        return l;
    }
}
