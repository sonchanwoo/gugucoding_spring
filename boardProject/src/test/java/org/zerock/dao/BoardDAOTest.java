package org.zerock.dao;

import static org.junit.Assert.assertNotNull;

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
public class BoardDAOTest {
    @Setter(onMethod_=@Autowired)
    private BoardDAO dao;
    
    @Test
    public void testDAO() {
        assertNotNull(dao);
    }
    
    @Test
    public void testGetList() {
        log.info(dao.getList());
    }
    
    @Test
    public void testGetListWithPage() {
        //dao.getListWithPage(new Criteria()).forEach(board->log.info(board));
        dao.getListWithPage(new Criteria(2,5)).forEach(board->log.info(board));
    }
    
    @Test
    public void testGetOne() {
        log.info(dao.read(4L));
    }
    
    @Test
    public void testInsert() {
        BoardVO vo = new BoardVO();
        vo.setContent("helo");
        vo.setTitle("title");
        vo.setWriter("me");
        
        log.info(dao.insert(vo));
    }
    
    @Test
    public void testInsertSelectKey() {
        BoardVO vo = new BoardVO();
        vo.setContent("helo");
        vo.setTitle("title");
        vo.setWriter("me");
        
        dao.insertSelectKey(vo);
        
        log.info(vo);
    }
    
    @Test
    public void testUpdate() {
        BoardVO vo = new BoardVO();
        vo.setBno(19L);
        vo.setContent("helo2");
        vo.setTitle("title2");
        vo.setWriter("me2");
        
        log.info(dao.update(vo));
    }
    
    @Test
    public void testRemove() {
        log.info(dao.delete(19L));
    }    
}
