package com.sist.secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.secure.mapper.MemMapper;
import com.sist.secure.vo.MemVO;

@Service
public class MemService {

    @Autowired
    private MemMapper m_mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 로그인
    public MemVO login(MemVO vo){
        // DB로부터 vo에 있는 m_id를 보내어
        // 해당 MemVO를 받아서 반환한다.
        // 이때 비밀번호가 일치하는지는
        // passwordEncoder에게 물어봐야한다.
        
        MemVO mvo = m_mapper.login(vo.getM_id());
        if(passwordEncoder.matches(vo.getM_pw(), mvo.getM_pw())){
            return mvo;
        }
        
        return null;
    }

    // 회원가입
    public int reg(MemVO mvo){
        // reg.jsp에서 전달되는 m_id, m_pw, m_name이
        // controller에서 mvo로 받은 것을 그대로 인자로 받음
        // 이 중 비밀번호를 암호화 시킨 후 저장한다.
        // String m_pw = passwordEncoder.encode(mvo.getM_pw());
        // mvo.setM_pw(m_pw);
        mvo.setM_pw(passwordEncoder.encode(mvo.getM_pw()));
        int res = m_mapper.reg(mvo);
        
        return res;
    }



}
