package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.dao.MyDAO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyServiceImpl implements MyService{

    private MyDAO dao;
    
    @Override
    public String getTime() {
        return dao.getTime();
    }
}
