package com.jianri.controller;

import com.jianri.common.ResponseCode;
import com.jianri.common.ServerResponse;
import com.jianri.pojo.Words;
import com.jianri.service.CollectionService;
import com.jianri.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    @RequestMapping("random_word.do")
    @ResponseBody
    public ServerResponse<Words> randomWord() {

        return wordService.getRandomWord();
    }

    @RequestMapping("collection_word.do")
    @ResponseBody
    public ServerResponse<Words> collectionWord(HttpSession session) {
        String phone = (String) session.getAttribute("phone");
        if (phone != null) {
            return wordService.getCollectionWord(phone);
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "你还没有登录哦！");
    }

}
