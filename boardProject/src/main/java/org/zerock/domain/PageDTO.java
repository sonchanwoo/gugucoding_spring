package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

    private int startPage;
    private int endPage;
    
    private int total;
    private Criteria cri;//페이지 번호를 만드려면, 몇개씩 출력했던지에 대한 이야기가 필요함.

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;
        
        this.endPage = (int)Math.ceil(this.total*1.0 / this.cri.getAmount());
        this.startPage = 1;          
    }
}
