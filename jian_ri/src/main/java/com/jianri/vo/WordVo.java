package com.jianri.vo;

/**
 * Created by ZenGx1n
 * 2020/4/9 2:23
 */
public class WordVo {

    private Integer id;

    private String word;

    //假名
    private String pseudonym;

    //释义
    private String definition;

    //单词发音地址
    private String pronunciation;

    //例句
    private String example;

    //是否被收藏 0：否 1：是
    private Integer beCollected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Integer getBeCollected() {
        return beCollected;
    }

    public void setBeCollected(Integer beCollected) {
        this.beCollected = beCollected;
    }
}
