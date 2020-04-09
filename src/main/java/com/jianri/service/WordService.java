package com.jianri.service;

import com.jianri.common.ServerResponse;
import com.jianri.pojo.Words;
import com.jianri.vo.WordVo;

import java.util.List;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
public interface WordService {

    ServerResponse<WordVo> getRandomWord(String phone);

    ServerResponse<List<Words>> getCollectionWord(String phone);

}
