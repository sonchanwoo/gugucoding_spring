package com.company.book.dao;

import java.util.List;

import com.company.book.dto.TodoDTO;

public interface TodoDAO {
	public List<TodoDTO> selectAll() throws Exception;
}
