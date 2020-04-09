package com.jianri.dao;

import com.jianri.pojo.Words;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Words record);

    int insertSelective(Words record);

    Words selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Words record);

    int updateByPrimaryKey(Words record);

    int getTotalWords();

    List<Words> selectAllByCollectionIds(@Param("collectionIds") List<Integer> collectionIds);
}