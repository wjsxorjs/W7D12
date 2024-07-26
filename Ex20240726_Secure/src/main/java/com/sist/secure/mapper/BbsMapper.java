package com.sist.secure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.secure.vo.BbsVO;
import com.sist.secure.vo.MemVO;

@Mapper
public interface BbsMapper{

    int count(String bname, String searchType, String searchValue);

    List<BbsVO> list(String bname, String begin, String end, String searchType, String searchValue);
    
}
