package com.sist.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.secure.mapper.BbsMapper;
import com.sist.secure.vo.BbsVO;

@Service
public class BbsService {
    @Autowired
    BbsMapper b_mapper;

    public int getCount(String bname, String searchType, String searchValue){
        return b_mapper.count(bname, searchType, searchValue);
    }

    public BbsVO[] getList(String bname, String begin, String end, String searchType, String searchValue){
        BbsVO[] b_ar = null;

        List<BbsVO> b_list = b_mapper.list(bname, begin, end, searchType, searchValue);
        if(b_list != null && b_list.size()>0){
            b_ar = new BbsVO[b_list.size()];
            b_list.toArray(b_ar);
        }

        return b_ar;
    }

}
