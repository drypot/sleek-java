package com.drypot.sleek.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

}
