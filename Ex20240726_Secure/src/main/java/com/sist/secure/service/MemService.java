package com.sist.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.secure.mapper.MemMapper;
import com.sist.secure.vo.MemVO;

@Service
public class MemService {

    @Autowired
    private MemMapper m_mapper;

    public MemVO[] login(String m_id){
        MemVO[] m_ar = null;

        List<MemVO> m_list = m_mapper.login(m_id);
        if(m_list != null && m_list.size()>0){
            m_ar = new MemVO[m_list.size()];
            m_list.toArray(m_ar);
        }
        return m_ar;
    }

    public int reg(MemVO mvo){
        int res = m_mapper.reg(mvo);
        
        return res;
    }



}
