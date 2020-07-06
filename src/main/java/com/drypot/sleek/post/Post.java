package com.drypot.sleek.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int id;
    private int threadId;
    private String userName;
    private String text;
    private LocalDateTime cdate;
    private boolean visible;
    private List<String> fileNameList;

    public void addFileName(String name) {
        if (fileNameList == null) {
            fileNameList = new ArrayList<String>(3);
        }
        fileNameList.add(name);
    }

    public void removeFileName(String name) {
        fileNameList.remove(name);
    }
}
