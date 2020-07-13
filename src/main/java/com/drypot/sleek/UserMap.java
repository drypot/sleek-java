package com.drypot.sleek;

import com.drypot.common.Config;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserMap {
    Map<String, User> map;

    public UserMap() {
        map = new HashMap<String, User>();
    }

    public void put(User u) {
        map.put(u.getName(), u);
    }

    public User get(String name) {
        return map.get(name);
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

    private static UserMap defaultMap;

    public static UserMap getDefault() throws IOException {
        if (defaultMap == null) {
            defaultMap = UserMap.from(Config.getDefault().getJsonNode("users"));
        }
        return defaultMap;
    }

    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public User findWithPassword(String password) {
        for(Map.Entry<String, User> e : map.entrySet()) {
            User u = e.getValue();
            if (encoder.matches(password, u.getHash())) {
                return u;
            }
        }
        return null;
    }
}
