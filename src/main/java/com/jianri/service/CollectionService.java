package com.jianri.service;

import com.jianri.common.ServerResponse;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:12
 */
public interface CollectionService {

    ServerResponse collect(Integer wordId, String phone);

    ServerResponse uncollect(Integer wordId, String phone);

}
