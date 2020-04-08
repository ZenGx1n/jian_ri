package com.jianri.dao;

import com.jianri.pojo.Collections;

public interface CollectionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}