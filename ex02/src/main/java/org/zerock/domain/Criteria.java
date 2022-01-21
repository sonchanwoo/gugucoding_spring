package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Criteria {
    
    @Setter private int pageNum;
    @Setter private int amount;
    private int startPage;

    public Criteria() {
        this(1,10);
    }
    public Criteria(int pageNum, int amount) {
        this.pageNum=pageNum;
        this.amount=amount;
        setStartPage();
    }
    
    public void setStartPage() {
        this.startPage = (this.pageNum - 1)*this.amount;
    }
}
