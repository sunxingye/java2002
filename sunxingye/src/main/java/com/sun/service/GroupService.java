package com.sun.service;

import com.sun.dao.BookGroupMapper;
import com.sun.pojo.BookGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 21:02 2020/7/23
 * @Version: 1.0
 */

public interface GroupService {


    List<BookGroup> findAll();
}
