package org.zerock.domain;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
