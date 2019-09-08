package com.hb.springboot.controller;

import com.hb.springboot.model.LeaveBill;
import com.hb.springboot.model.Result;
import com.hb.springboot.service.LeaveBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 11:25
 **/

@Controller
@RequestMapping("/leave")
public class LeaveBillController {

    @Autowired
    private LeaveBillService service;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(LeaveBill leaveBill){
        Result result = new Result();
        boolean success = service.saveLeave(leaveBill);
        result.setSuccess(success);
        if (success){
            result.setMessage("请假单添加成功");
        }else {
            result.setMessage("请假单添加失败");
        }
        return result;
    }

}