package com.example.server.controller;


import com.example.server.common.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ping")
public class TestController extends BaseController{

    String uuid = UUID.randomUUID().toString();

    @GetMapping("")
    public ResponseVO pingTest(){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(uuid);
        return responseVO;
    }
}
