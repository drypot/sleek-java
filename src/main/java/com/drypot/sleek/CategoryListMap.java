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


}
