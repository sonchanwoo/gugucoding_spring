package com.company.dao;

import java.util.List;

import com.company.dto.SampleDTO;


public interface SampleDAO {
    //List<SampleDTO> select(int bno);
    List<SampleDTO> select(SampleDTO dto);
}
