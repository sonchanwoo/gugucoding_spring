package com.company.book.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.book.dto.TodoDTO;

@Repository
public class TodoDAOImpl implements TodoDAO{

	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.company.book.mappers.todoMapper";
    
    @Override
    public List<TodoDTO> selectAll() throws Exception {
    	System.out.println(sqlSession);
        return sqlSession.selectList(Namespace+".selectAll");
    }

}
