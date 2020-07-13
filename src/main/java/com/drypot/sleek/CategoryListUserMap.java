package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class CategoryListUserMap {

    private Map<String, CategoryList> map;

    public CategoryListUserMap() {
        map = new HashMap<>();
    }

    public void put(String user1, CategoryList l1) {
        map.put(user1, l1);
    }

    public CategoryList get(String name) {
        return map.get(name);
    }

    public static CategoryListUserMap from(JsonNode categories) {
        CategoryListUserMap perUser = new CategoryListUserMap();
        for(JsonNode categoryNode: categories) {
            Category c = new Category(categoryNode.get("id").asInt(), categoryNode.get("name").asText());
            for(JsonNode userNode : categoryNode.get("users")) {
                String userName = userNode.asText();
                CategoryList l = perUser.get(userName);
                if (l == null) {
                    l = new CategoryList();
                    perUser.put(userName, l);
                }
                l.add(c);
            }
        }
        return perUser;
    }

}
