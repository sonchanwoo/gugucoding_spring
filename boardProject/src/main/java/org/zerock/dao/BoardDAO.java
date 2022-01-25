package org.zerock.dao;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardDAO {
    public List<BoardVO> getList();

    public BoardVO read(Long bno);

    public int insert(BoardVO vo);

    public int update(BoardVO vo);

    public int delete(Long bno);
}