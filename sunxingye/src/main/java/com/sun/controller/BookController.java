package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.pojo.ElectronicBook;
import com.sun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 20:45 2020/7/23
 * @Version: 1.0
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("findAll")
    @ResponseBody
    public Map findAll(Integer page, Integer limit){

        PageHelper.startPage(page, limit);

        List<ElectronicBook> bookList = bookService.findAll();

        PageInfo<ElectronicBook> pageInfo = new PageInfo<>(bookList);

        System.out.println(pageInfo);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());
        return map;

    }


    @RequestMapping("groupFind")
    @ResponseBody
    public List<ElectronicBook> groupFind(Integer groupId){
        return  bookService.groupFind(groupId);
    }


//插入增加一本书
    @RequestMapping("insertBook")
    @ResponseBody
    public String insertBook(ElectronicBook electronicBook){
        System.out.println(electronicBook);
        bookService.insertBook(electronicBook);
        return "succcessful";
    }


    //插入增加一本书
    @RequestMapping("updataBook")
    @ResponseBody
    public String updataBook(ElectronicBook electronicBook){
        System.out.println(electronicBook);
        bookService.updataBook(electronicBook);
        return "succcessful";
    }

    @RequestMapping("findBookGroup")
    @ResponseBody
    public Map findBookGroup(Integer page, Integer limit){

        return bookService.findBookGroup(page,limit);

    }


    //删除一本书
    @RequestMapping("deleteBook")
    @ResponseBody
    public String deleteBook(Integer bookId){
        System.out.println(bookId);
        bookService.deleteBook(bookId);
        return "succcessful";
    }
    //删除多本书
    @PostMapping("deleteMoreBook")
    @ResponseBody
    public String deleteMoreBook(@RequestBody List<ElectronicBook> obj){
        bookService.deleteMoreBook(obj);
        return "succcessful";
    }
}
