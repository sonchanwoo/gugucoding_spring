package com.company.book.mybatis;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.book.dao.TodoDAOImpl;
import com.company.book.dto.TodoDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class MyBatisTest2 {
	@Inject
	private TodoDAOImpl dao;
	@Test
	public void test() {
		
		
		try {
			List<TodoDTO> list = dao.selectAll();
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("TEST!!!!!!!!!!!!!!!......................");
		
	}
}
