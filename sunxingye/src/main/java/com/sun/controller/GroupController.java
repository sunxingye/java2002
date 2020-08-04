package com.sun.controller;

import com.sun.pojo.BookGroup;
import com.sun.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 21:00 2020/7/23
 * @Version: 1.0
 */

@Controller
@RequestMapping("group")
public class GroupController {


    @Autowired
    private GroupService groupService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<BookGroup> findAll(){
        return  groupService.findAll();
    }

}
