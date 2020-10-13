package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

public class CategoryListMapJsonLoader {

    public static CategoryListMap loadFrom(JsonNode categories) {
        CategoryListMap perUser = new CategoryListMap();
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
