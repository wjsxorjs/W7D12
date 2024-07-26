package com.sist.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.secure.service.BbsService;


@Controller
public class BbsController {
    // DB활용을 위한 service
    
    // 로그인 처리를 위한 세션 
    @Autowired
    private HttpSession session;

    @Autowired
    private BbsService b_service;

    @RequestMapping("/")
    public String home() {
        return "index";
    }


}
