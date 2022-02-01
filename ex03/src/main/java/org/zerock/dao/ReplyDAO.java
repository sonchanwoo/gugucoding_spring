package org.zerock.dao;

import org.zerock.domain.ReplyVO;

public interface ReplyDAO {
    public int insert(ReplyVO vo);

    public ReplyVO read(Long bno);

    public int delete(Long bno);

    public int update(ReplyVO reply);

    //public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);

    public int getCountByBno(Long bno);
}
