package com.wincor.base.controller;

import com.wincor.base.pojo.Label;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
//记得跨域
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @RequestMapping(method = RequestMethod.GET )
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功");
    }

    //@RequestMapping 注解可以同 @PathVariable 注解一起使用，用来处理动态的 URI,labelId是动态填充进去的
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET )
    public Result findById(@PathVariable String labelId){
        return new Result(true, StatusCode.OK,"查询成功");
    }

    @RequestMapping(method = RequestMethod.POST )
    public Result save(@RequestBody Label label){
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "{/labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId ,@RequestBody Label label){
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId ){
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
