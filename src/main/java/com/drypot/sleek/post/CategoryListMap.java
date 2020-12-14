package com.drypot.sleek.post;

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
