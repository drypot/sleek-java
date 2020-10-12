package com.drypot.sleek;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CategoryListMap {

    private Map<String, CategoryList> map;

    public CategoryListMap() {
        map = new HashMap<>();
    }

    public void put(String userName, CategoryList categoryList) {
        map.put(userName, categoryList);
    }

    public CategoryList get(String userName) {
        return map.get(userName);
    }

    public static CategoryListMap from(JsonNode categories) {
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

    private static CategoryListMap defaultMap;

    public static CategoryListMap getDefault() throws IOException {
        if (defaultMap == null) {
            defaultMap = CategoryListMap.from(UserLoader.getDefault().getJsonNode("categories"));
        }
        return defaultMap;
    }

}
