package com.sist.secure.mapper;

import java.util.List;
import com.sist.secure.vo.MemVO;

public interface MemMapper{

    public List<MemVO> login(String m_id);

    public int reg(MemVO mvo);
    
}
