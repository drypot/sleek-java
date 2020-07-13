package com.drypot.sleek;

import com.drypot.common.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CategoryListUserMapTest {

    @Test
    @DisplayName("we can create categoryListUserMap")
    void create() {
        CategoryListUserMap l = new CategoryListUserMap();
    }

    @Test
    @DisplayName("we can put categoryList to userMap")
    void add() {
        CategoryListUserMap l = new CategoryListUserMap();
        CategoryList l1 = new CategoryList();
        CategoryList l2 = new CategoryList();

        l.put("user1", l1);
        l.put("user2", l2);

        assertEquals(l1, l.get("user1"));
        assertEquals(l2, l.get("user2"));
    }

    @Test
    @DisplayName("we can load categoryListUserMap from Json")
    void loadFromJson() throws IOException {
        Config c = Config.fromCache();
        CategoryListUserMap perUser = CategoryListUserMap.from(c.getJsonNode("categories"));
        CategoryList l;

        l = perUser.get("user");
        assertTrue(l.contains(100));
        assertTrue(l.contains(104));
        assertFalse(l.contains(60));
        assertFalse(l.contains(40));

        l = perUser.get("cheater");
        assertTrue(l.contains(100));
        assertTrue(l.contains(104));
        assertTrue(l.contains(60));
        assertFalse(l.contains(40));
    }
}
