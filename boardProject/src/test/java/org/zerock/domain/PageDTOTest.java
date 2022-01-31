package org.zerock.domain;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class PageDTOTest {
    @Test
    public void testMathCeil() {
        log.info(Math.ceil(64.0/10));
        log.info(Math.ceil(7.0/10));
    }
    
    @Test
    public void testToString() {
        log.info(new PageDTO(new Criteria(), 46));
    }
}
