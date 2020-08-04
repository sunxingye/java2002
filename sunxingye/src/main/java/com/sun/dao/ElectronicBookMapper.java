package com.sun.dao;

import com.sun.pojo.ElectronicBook;
import com.sun.pojo.ElectronicBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectronicBookMapper {

//    联表查询
    List<ElectronicBook> findBookGroup();

    long countByExample(ElectronicBookExample example);

    int deleteByExample(ElectronicBookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(ElectronicBook record);

    int insertSelective(ElectronicBook record);

    List<ElectronicBook> selectByExample(ElectronicBookExample example);


    ElectronicBook selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") ElectronicBook record, @Param("example") ElectronicBookExample example);

    int updateByExample(@Param("record") ElectronicBook record, @Param("example") ElectronicBookExample example);

    int updateByPrimaryKeySelective(ElectronicBook record);

    int updateByPrimaryKey(ElectronicBook record);

    void deleteMoreBook(List<Integer> list);
}