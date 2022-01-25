package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardDAO dao;
    
    @Override
    public List<BoardVO> getList() {
        return dao.getList();
    }

    @Override
    public BoardVO get(Long bno) {
        return dao.read(bno);
    }

    @Override
    public void register(BoardVO vo) {
        dao.insert(vo);
    }

    @Override
    public boolean modify(BoardVO vo) {
        return dao.update(vo)==1;
    }

    @Override
    public boolean remove(Long bno) {
        return dao.delete(bno)==1;
    }

}
