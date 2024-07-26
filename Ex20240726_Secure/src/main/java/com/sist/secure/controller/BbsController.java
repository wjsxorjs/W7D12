package com.sist.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.secure.service.BbsService;
import com.sist.secure.util.Paging2;
import com.sist.secure.vo.BbsVO;


@Controller
public class BbsController {
    // DB활용을 위한 service
    @Autowired
    private BbsService b_service;

    
    
    
    @RequestMapping("/list")
    public ModelAndView bbsList(String bname, String cPage, String searchType, String searchValue) {
        ModelAndView mv = new ModelAndView();
        
        int nowPage = 1;
        
        if(bname == null){
            bname = "bbs";
        }
        
        // 현재 페이지 값인 cPage가 null이 아니라면
        // 사용자가 가고자 하는 페이지가 있으므로
        // nowPage값을 cPage로 변경하자!
        if(cPage!=null){
            nowPage = Integer.parseInt(cPage);
        }
        
        // 총 게시물의 수를 구해야 한다.
        int totalRecord = b_service.getCount(bname, searchType, searchValue);
        
        // Paging2 객체 생성 후 페이징 HTML코드 생성까지 수행하는 객체 준비
        Paging2 b_page = new Paging2(10, 3, totalRecord, nowPage, bname);
        
        
        // view 페이지에서 보여질 게시물들을 얻어내어 mv에 저장한다.
        BbsVO[] b_ar = b_service.getList(bname, String.valueOf(b_page.getBegin()), String.valueOf(b_page.getEnd()), searchType, searchValue);
        
		mv.addObject("bname", bname);
		mv.addObject("b_ar", b_ar);
		mv.addObject("b_page", b_page);
		mv.addObject("pageCode", b_page.getSb().toString());

        mv.setViewName(bname+"/list");
        
        return mv;
    }


}
