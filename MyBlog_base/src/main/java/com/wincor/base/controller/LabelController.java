package com.wincor.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//记得跨域
@CrossOrigin
@RequestMapping("/lable")
public class LabelController {
    @RequestMapping(method = RequestMethod.GET )
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功");
    }
}
