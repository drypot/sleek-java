package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

public class UserMapJsonLoader {

    public static UserMap loadFrom(JsonNode users) {
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