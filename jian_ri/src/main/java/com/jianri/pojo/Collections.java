package com.jianri.pojo;

import java.util.Date;

public class Collections {
    private Integer id;

    private String userId;

    private Integer wordId;

    private Date createTime;

    private Date updateTime;

    public Collections(Integer id, String userId, Integer wordId, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.wordId = wordId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Collections() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}