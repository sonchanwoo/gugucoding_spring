package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
    public List<BoardVO> getList();

    public BoardVO get(Long bno);

    public boolean register(BoardVO vo);

    public boolean modify(BoardVO vo);
    
    public boolean remove(Long bno);
}
