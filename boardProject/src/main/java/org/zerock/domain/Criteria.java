package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@AllArgsConstructor
public class Criteria {
    
    private int pageNum;
    private int amount;

    public Criteria() {
        this(1,10);
    }
}
