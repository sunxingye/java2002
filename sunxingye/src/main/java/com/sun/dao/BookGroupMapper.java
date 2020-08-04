package com.sun.dao;

import com.sun.pojo.BookGroup;
import com.sun.pojo.BookGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookGroupMapper {
    long countByExample(BookGroupExample example);

    int deleteByExample(BookGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(BookGroup record);

    int insertSelective(BookGroup record);

    List<BookGroup> selectByExample(BookGroupExample example);

    BookGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") BookGroup record, @Param("example") BookGroupExample example);

    int updateByExample(@Param("record") BookGroup record, @Param("example") BookGroupExample example);

    int updateByPrimaryKeySelective(BookGroup record);

    int updateByPrimaryKey(BookGroup record);
}