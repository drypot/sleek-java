package com.drypot.sleek.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryList implements Iterable<Category> {
    List<Category> list;

    public CategoryList() {
        list = new ArrayList();
    }

    public void add(Category c) {
        list.add(c);
    }

    public Category get(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<Category> iterator() {
        return list.iterator();
    }

    public boolean contains(int i) {
        for(Category c : list) {
            if (c.getId() == i) return true;
        }
        return false;
    }
}
