package com.drypot.sleek.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostThread {

    private int id;
    private int categoryId;
    private int hit;
    private int length;
    private LocalDateTime cdate;
    private LocalDateTime udate;
    private String userName;
    private String title;

    public boolean postIsFirstPost(Post p) {
        return cdate.equals(p.getCdate());
    }

    private static AtomicInteger idSeed = new AtomicInteger();

    public static void setIdSeed(int newValue) {
        idSeed.set(newValue + 1);
    }

    public static int getNewId() {
        return idSeed.getAndIncrement();
    }

}
