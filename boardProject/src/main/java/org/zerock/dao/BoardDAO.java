package org.zerock.dao;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardDAO {
    public List<BoardVO> getList();
    
    public List<BoardVO> getListWithPage(Criteria cri);

    public BoardVO read(Long bno);

    public int insert(BoardVO vo);

    public int update(BoardVO vo);

    public int delete(Long bno);

    public int insertSelectKey(BoardVO vo);
}
