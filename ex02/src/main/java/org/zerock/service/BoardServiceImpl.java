package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        mapper.insert(board);
    }

    @Override
    public BoardVO get(Long bno) {
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        return mapper.update(board) == 1;//true
    }

    @Override
    public boolean remove(Long bno) {
        return mapper.delete(bno)==1;
    }

    @Override
    public int getLastBno() {        
        return mapper.getLastBno();
    }

    @Override
    public List<BoardVO> getList(Criteria cti) {
        return mapper.getList(cti);
    }

    @Override
    public int getTotal(Criteria cri) {
        return mapper.getTotalCount(cri);
    }

}
