package com.bitc.javateam1.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private int cmIdx;
    private String cmId;
    private String cmNick;
    private String title;
    private String content;
    private String postdate;
    private int visitCount;
    private int cmNum;
}
