package com.sun.service.impl;

import com.sun.dao.BookGroupMapper;
import com.sun.pojo.BookGroup;
import com.sun.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 21:02 2020/7/23
 * @Version: 1.0
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private BookGroupMapper bookGroupMapper;

    @Override
    public List<BookGroup> findAll() {
        return bookGroupMapper.selectByExample(null);
    }
}
