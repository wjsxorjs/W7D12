package com.sist.secure.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sist.secure.vo.MemVO;

@Mapper
public interface MemMapper{

    MemVO login(String m_id);

    int reg(MemVO mvo);
    
}
