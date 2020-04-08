package com.jianri.service.impl;

import com.jianri.common.ServerResponse;
import com.jianri.dao.WordsMapper;
import com.jianri.pojo.Words;
import com.jianri.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
@Service("wordService")
public class WordServiceImpl implements WordService {

    @Autowired
    private WordsMapper wordsMapper;

    @Override
    public ServerResponse<Words> getRandomWord() {
        int wordCount = wordsMapper.getTotalWords();
        Random random = new Random();
        int fre = 0;
        while (fre <= 10) {
            int id = random.nextInt(wordCount) + 1;
            System.out.println(id);
            Words word = wordsMapper.selectByPrimaryKey(id);
            if(word != null) {
                return ServerResponse.createBySuccess(word);
            }
            fre += 1;
        }

        return ServerResponse.createByErrorMessage("获取随机单词失败");
    }

    @Override
    public ServerResponse<Words> getCollectionWord(String phone) {
        return ServerResponse.createByError();
    }

}
