package com.drypot.sleek.json;

import com.drypot.sleek.post.Category;
import com.drypot.sleek.post.CategoryList;
import com.drypot.sleek.post.CategoryListMap;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonCategoryListMap {

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
