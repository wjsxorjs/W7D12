package com.sist.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sist.secure.service.MemService;
import com.sist.secure.vo.MemVO;


@Controller
public class MemberController {
    // DB활용을 위한 service
    
    // 로그인 처리를 위한 세션 
    @Autowired
    private HttpSession session;

    @Autowired
    private MemService m_service;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public ModelAndView reg2(MemVO mvo) {
        System.out.println("MVO: "+ mvo.getM_id()+" || "+mvo.getM_name());
        
        // Service를 이용하여 회원등록
        int chk = m_service.reg(mvo);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @PostMapping("/reqLogin")
    public ModelAndView login(MemVO vo) {
        System.out.println("MVO: "+ vo.getM_id()+" || "+vo.getM_pw());
        ModelAndView mv =new ModelAndView();
        
        // Service를 이용하여 로그인 인증확인
        MemVO mvo = m_service.login(vo);
        if(mvo == null){
            mv.addObject("status","1");
            mv.setViewName("login");
            return mv;
        }
        session.setAttribute("mvo", mvo);
        mv.setViewName("redirect:/");
        
        return mv;
    }
    
    @GetMapping("/mem_logout")
    public String logout() {
        session.removeAttribute("mvo");
        return "redirect:/";
    }


}
