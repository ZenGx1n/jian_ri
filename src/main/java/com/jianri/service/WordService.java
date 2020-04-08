package com.jianri.service;

import com.jianri.common.ServerResponse;
import com.jianri.pojo.Words;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
public interface WordService {

    ServerResponse<Words> getRandomWord();

    ServerResponse<Words> getCollectionWord(String phone);

}
