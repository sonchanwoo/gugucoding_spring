package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.dao.ReplyDAO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private ReplyDAO dao;    
    
    @Override
    public int register(ReplyVO vo) {

      return dao.insert(vo);

    }

    @Override
    public ReplyVO get(Long rno) {

      return dao.read(rno);

    }

    @Override
    public int modify(ReplyVO vo) {

      return dao.update(vo);

    }

    @Override
    public int remove(Long rno) {

      return dao.delete(rno);

    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {

      return dao.getListWithPaging(cri, bno);

    }

}
