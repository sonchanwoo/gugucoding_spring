package com.company.book.mybatis;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Log4j
public class MyBatisTest {

	@Inject
	private SqlSessionFactory sqlFactory;
	
	private static final String Namespace = "com.company.book.mappers.todoMapper";

	@Test
	public void test() {
		log.info(sqlFactory);
	}
	@Test
	public void test2() throws Exception {
		try(SqlSession session = sqlFactory.openSession()){

			log.info(session.selectList(Namespace+".selectAll"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
