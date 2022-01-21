package com.company.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.SampleDAO;
import com.company.dto.SampleDTO;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class Tests {

    @Setter(onMethod_ = @Autowired)
    private SampleDAO dao;

    @Test
    public void test1() throws Exception {
        // dao.select(4);        
        SampleDTO dto = new SampleDTO(); dto.setBno(4); dao.select(dto);
        
    }
}
