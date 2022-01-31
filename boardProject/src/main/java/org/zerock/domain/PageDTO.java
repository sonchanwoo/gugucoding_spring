package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    // 일단 5개만 보이게 출력
    private static final int MAX_PAGE_COUNT = 4;

    private int startPage;
    private int endPage;

    private int total;
    private Criteria cri;

    private boolean prev;
    private boolean next;

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;

        this.endPage = (int) Math.ceil((this.cri.getPageNum() / (MAX_PAGE_COUNT * 1.0))) * MAX_PAGE_COUNT;
        this.startPage = this.endPage - (MAX_PAGE_COUNT - 1);
        
        int realEnd = (int)Math.ceil(this.total*1.0 / this.cri.getAmount());
        
        if(this.endPage > realEnd)
            this.endPage = realEnd;
        
        this.prev = startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
