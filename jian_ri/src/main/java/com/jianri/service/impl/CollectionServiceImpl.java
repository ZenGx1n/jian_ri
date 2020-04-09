package com.jianri.service.impl;

import com.jianri.common.ServerResponse;
import com.jianri.dao.CollectionsMapper;
import com.jianri.dao.WordsMapper;
import com.jianri.pojo.Collections;
import com.jianri.pojo.Words;
import com.jianri.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private WordsMapper wordsMapper;

    @Autowired
    private CollectionsMapper collectionsMapper;

    @Override
    public ServerResponse collect(Integer wordId, String phone) {
        Words words = wordsMapper.selectByPrimaryKey(wordId);
        if (words != null) {
            int count = collectionsMapper.countByWordIdAndPhone(wordId, phone);
            if (count > 0) {
                return ServerResponse.createByErrorMessage("你已经收藏这个单词了！");
            }
            Collections collections = new Collections();
            collections.setUserId(phone);
            collections.setWordId(wordId);
            collections.setCreateTime(new Date());
            collections.setUpdateTime(new Date());
            int resultCount = collectionsMapper.insertSelective(collections);
            if (resultCount > 0) {
                return ServerResponse.createBySuccessMessage("收藏单词成功！");
            }
            return ServerResponse.createByErrorMessage("收藏单词失败！");
        }
        return ServerResponse.createByErrorMessage("你收藏的单词不存在");
    }

    @Override
    public ServerResponse uncollect(Integer wordId, String phone) {
        Words words = wordsMapper.selectByPrimaryKey(wordId);
        if (words != null) {
            int count = collectionsMapper.countByWordIdAndPhone(wordId, phone);
            if (count > 0) {
                collectionsMapper.deleteByWordIdAndPhone(wordId, phone);
                return ServerResponse.createByErrorMessage("取消收藏单词成功！");
            }
        }

        return ServerResponse.createByErrorMessage("你取消收藏的单词不存在");
    }

}
