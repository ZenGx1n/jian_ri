package com.jianri.dao;

import com.jianri.pojo.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);

    int countByWordIdAndPhone(@Param("wordId") Integer wordId, @Param("phone") String phone);

    List<Integer> selectAllByPhone(@Param("phone") String phone);

    int deleteByWordIdAndPhone(@Param("wordId") Integer wordId, @Param("phone") String phone);
}