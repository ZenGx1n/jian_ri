package com.jianri.controller;

import com.jianri.common.ResponseCode;
import com.jianri.common.ServerResponse;
import com.jianri.pojo.Words;
import com.jianri.service.CollectionService;
import com.jianri.service.WordService;
import com.jianri.vo.WordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ZenGx1n
 * 2020/4/8 11:08
 */
@Controller
public class GlobalController {


    @Autowired
    private CollectionService collectionService;

    @Autowired
    private WordService wordService;

    /**
     * 用户登录接口（获取用户的手机号）
     *
     * @param phoneNumber
     * @param session
     * @return
     */
    @RequestMapping("login.do")
    @ResponseBody
    public ServerResponse login(String phoneNumber, HttpSession session) {
        if (phoneNumber != null) {
            session.setAttribute("phone", phoneNumber);
            return ServerResponse.createBySuccessMessage("登录成功");
        }

        return ServerResponse.createByErrorMessage("登录失败");
    }

    /**
     * 随机获取单词接口
     * @param session
     * @return
     */
    @RequestMapping("random_word.do")
    @ResponseBody
    public ServerResponse<WordVo> randomWord(HttpSession session) {
        String phone = (String) session.getAttribute("phone");

        return wordService.getRandomWord(phone);
    }

    /**
     * 获取登录用户的收藏单词接口
     * @param session
     * @return
     */
    @RequestMapping("collection_word.do")
    @ResponseBody
    public ServerResponse<List<Words>> collectionWord(HttpSession session) {
        String phone = (String) session.getAttribute("phone");
        if (phone != null) {
            return wordService.getCollectionWord(phone);
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "你还没有登录哦！");
    }

    /**
     * 收藏单词接口
     * @param wordId
     * @param session
     * @return
     */
    @RequestMapping("collect.do")
    @ResponseBody
    public ServerResponse collect(Integer wordId, HttpSession session) {
        String phone = (String) session.getAttribute("phone");
        if (phone != null) {
            return collectionService.collect(wordId, phone);
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "你还没有登录哦！");
    }

    /**
     * 取消收藏接口
     * @param wordId
     * @param session
     * @return
     */
    @RequestMapping("uncollect.do")
    @ResponseBody
    public ServerResponse uncollect(Integer wordId, HttpSession session) {
        String phone = (String) session.getAttribute("phone");
        if (phone != null) {
            return collectionService.uncollect(wordId, phone);
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "你还没有登录哦！");
    }

}
