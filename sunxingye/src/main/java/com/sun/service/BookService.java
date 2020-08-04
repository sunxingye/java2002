package com.sun.service;

import com.sun.pojo.ElectronicBook;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 20:46 2020/7/23
 * @Version: 1.0
 */
public interface BookService {


    List<ElectronicBook> findAll();

    List<ElectronicBook> groupFind(Integer groupId);

    Map findBookGroup(Integer page, Integer limit);

    void insertBook(ElectronicBook electronicBook);

    void updataBook(ElectronicBook electronicBook);

    void deleteBook(Integer bookID);

    void deleteMoreBook(List<ElectronicBook> obj);
}
