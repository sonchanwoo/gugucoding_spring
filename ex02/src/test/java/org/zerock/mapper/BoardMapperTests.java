package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;
    /*
    @Test
    public void testGetList() {
        
       mapper.getList().forEach(board->log.info(board));
    }*/
    
    /*
    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("글1");
        board.setContent("내용1");
        board.setWriter("chanwoo");
        
        mapper.insert(board);
        
        log.info(board);
        
    }*/
    /*
    @Test
    public void testRead() {
        BoardVO board = mapper.read(2L);
        
        log.info(board);
    }*/
    /*
    @Test
    public void testDelete() {
        //삭제된 개수를 반환!
        //log.info("delete count: "+mapper.delete(3L));
        log.info("delete count: "+mapper.delete(1L));
    }*/
    
    /*
    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();
        board.setBno(2L);
        board.setTitle("수정된 제목");
        board.setContent("수정 된 내용");
        board.setWriter("chan2");
        
        log.info(mapper.update(board));
    }*/
    
    /*
    @Test
    public void testGetLastBno() {
        log.info("test getLastBno...............................");
        //log.info(mapper.getLastBno());
        mapper.getLastBno();
    }*/
    /*
    @Test
    public void testPaging() {
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(5);
        
        List<BoardVO> list  =mapper.getListWithPaging(cri);
        
        list.forEach(board -> log.info(board.getBno()));
    }*/
    
}
