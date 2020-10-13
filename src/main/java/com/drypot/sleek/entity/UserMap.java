package com.drypot.sleek.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public int size() {
        return map.size();
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
