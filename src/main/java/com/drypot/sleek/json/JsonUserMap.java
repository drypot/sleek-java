package com.drypot.sleek.json;

import com.drypot.sleek.entity.User;
import com.drypot.sleek.entity.UserMap;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonUserMap {

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
