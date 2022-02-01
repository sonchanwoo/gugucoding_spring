package org.zerock.domain;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class PageDTOTest {
    @Test
    public void testMathCeil() {
        log.info(Math.ceil(64.0/10));
        log.info(Math.ceil(7.0/10));
        
        log.info(Math.ceil(7.1));//ceil은 소수점 올림이구나
        
        //한페이지당 5개씩 보여주는데(cri.amount = 5)
        //현재 페이지가 9임(cri.pageNum = 9)
        //페이지 번호는 7씩 자르고(max = 7)
        //끝페이지가 14라는 건 우째알지?(pageNum을 max으로 나눈 걸 올림하니까 2가나오고 max를 곱했네)
        //시작페이지가 8이라는건?(start - 6)(7씩자르니까)        
        log.info((int)Math.ceil( (9/(7*1.0) )) * 7);
    }
    
    @Test
    public void testToString() {
        log.info(new PageDTO(new Criteria(), 46));
    }
}
