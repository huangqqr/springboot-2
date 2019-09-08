package com.hb.springboot.controller;

import com.hb.springboot.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: huangbo
 * @create: 2019-09-05 10:55
 **/

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    //@Autowired
    //private DeptService deptService;

    @ResponseBody
    //@GetMapping("/h")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result getByIdUser(Integer id){
        //Dept dept =  deptService.selectById(id);
        return new Result("HelloWord");
    }
}