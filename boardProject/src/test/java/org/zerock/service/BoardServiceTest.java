package org.zerock.service;

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
public class BoardServiceTest {

    @Setter(onMethod_=@Autowired)
    private BoardService service;
    
    @Test
    public void test() {
        assertNotNull(service);
    }
    
    @Test
    public void testGetList() {
        log.info(service.getList());
    }
    
    @Test
    public void testGetListWithPage() {
        service.getListWithPage(new Criteria()).forEach(board -> log.info(board));;
    }
    
    @Test
    public void testGet() {
        log.info(service.get(4L));
    }
    
    @Test
    public void testRegister() {
        BoardVO vo = new BoardVO();
        vo.setContent("helo");
        vo.setTitle("title");
        vo.setWriter("me");
        
        service.register(vo);
    }
    
    @Test
    public void testModify() {
        BoardVO vo = new BoardVO();
        vo.setBno(20L);
        vo.setContent("helo2");
        vo.setTitle("title2");
        vo.setWriter("me3");
        
        service.modify(vo);        
    }
    
    @Test
    public void testRemove() {
        service.remove(20L);
    }
}
