package com.sun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.dao.ElectronicBookMapper;
import com.sun.pojo.ElectronicBook;
import com.sun.pojo.ElectronicBookExample;
import com.sun.service.BookService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 20:46 2020/7/23
 * @Version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ElectronicBookMapper bookMapper;

    @Override
    public List<ElectronicBook> findAll() {
        return bookMapper.selectByExample(null);
    }

    @Override
    public List<ElectronicBook> groupFind(Integer groupId) {
        ElectronicBookExample bookExample = new ElectronicBookExample();

        ElectronicBookExample.Criteria criteria = bookExample.createCriteria();

        criteria.andGroupIdEqualTo(groupId);

        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public Map findBookGroup(Integer page, Integer limit) {


        PageHelper.startPage(page, limit);

        List<ElectronicBook> bookList = bookMapper.findBookGroup();

        PageInfo<ElectronicBook> pageInfo = new PageInfo<>(bookList);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());//总记录数
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    public void insertBook(ElectronicBook electronicBook) {

        bookMapper.insertSelective(electronicBook);
    }

    @Override
    public void updataBook(ElectronicBook electronicBook) {
        bookMapper.updateByPrimaryKey(electronicBook);
    }

//    删除书籍
    @Override
    public void deleteBook(Integer bookID) {
        bookMapper.deleteByPrimaryKey(bookID);
    }

    @Override
    public void deleteMoreBook(List<ElectronicBook> obj) {

        List<Integer> list=new ArrayList<>();
        Iterator<ElectronicBook> iterator = obj.iterator();

        while(iterator.hasNext()){
            list.add(iterator.next().getBookId());
        }

        bookMapper.deleteMoreBook(list);
    }
}
