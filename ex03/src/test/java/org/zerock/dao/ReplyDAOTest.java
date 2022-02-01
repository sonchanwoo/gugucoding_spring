package org.zerock.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyDAOTest {

    @Setter(onMethod_ = @Autowired)
    private ReplyDAO dao;

    @Test
    public void testCreate() {

            ReplyVO vo = new ReplyVO();

            // 게시물의 번호
            vo.setBno(9l);
            vo.setReply("댓글 테스트 " );
            vo.setReplyer("replyer" );

            dao.insert(vo);

    }

    @Test
    public void testRead() {

        Long targetRno = 3L;

        log.info( dao.read(targetRno));

    }

    @Test
    public void testDAO() {

        log.info(dao);
    }

    @Test
    public void testDelete() {

        Long targetRno = 3L;

        dao.delete(targetRno);
    }

    @Test
    public void testUpdate() {

        ReplyVO vo = new ReplyVO();
        vo.setRno(4l);
        vo.setBno(9l);
        vo.setReply("Update Reply ");

        dao.update(vo);
    }
}
