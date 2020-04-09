package com.jianri.service.impl;

import com.jianri.common.ServerResponse;
import com.jianri.dao.CollectionsMapper;
import com.jianri.dao.WordsMapper;
import com.jianri.pojo.Words;
import com.jianri.service.WordService;
import com.jianri.vo.WordVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
@Service("wordService")
public class WordServiceImpl implements WordService {

    @Autowired
    private WordsMapper wordsMapper;

    @Autowired
    private CollectionsMapper collectionsMapper;

    @Override
    public ServerResponse<WordVo> getRandomWord(String phone) {
        int wordCount = wordsMapper.getTotalWords();
        Random random = new Random();
        WordVo wordVo = new WordVo();
        int fre = 0;
        while (fre <= 10) {
            int id = random.nextInt(wordCount) + 1;
            System.out.println(id);
            Words word = wordsMapper.selectByPrimaryKey(id);
            if (word != null) {
                if (phone != null) {
                    int resultCount = collectionsMapper.countByWordIdAndPhone(word.getId(), phone);
                    if (resultCount > 0) {
                        wordVo = assembleWordVo(word);
                        wordVo.setBeCollected(1);
                        return ServerResponse.createBySuccess(wordVo);
                    }
                }
                wordVo = assembleWordVo(word);
                wordVo.setBeCollected(0);
                return ServerResponse.createBySuccess(wordVo);
            }
            fre += 1;
        }

        return ServerResponse.createByErrorMessage("获取随机单词失败");
    }

    @Override
    public ServerResponse<List<Words>> getCollectionWord(String phone) {
        List<Integer> collectionIdList = collectionsMapper.selectAllByPhone(phone);
        if (CollectionUtils.isNotEmpty(collectionIdList)) {
            List<Words> wordsList = wordsMapper.selectAllByCollectionIds(collectionIdList);
            return ServerResponse.createBySuccess(wordsList);
        }

        return ServerResponse.createByErrorMessage("你还没有收藏任何单词！");
    }

    private WordVo assembleWordVo(Words word) {
        WordVo wordVo = new WordVo();
        wordVo.setId(word.getId());
        wordVo.setDefinition(word.getDefinition());
        wordVo.setExample(word.getExample());
        wordVo.setPronunciation(word.getPronunciation());
        wordVo.setWord(word.getWord());
        wordVo.setPseudonym(word.getPseudonym());

        return wordVo;
    }

}
