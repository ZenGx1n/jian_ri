package com.jianri.pojo;

public class Words {
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

    public Words(Integer id, String word, String pseudonym, String definition, String pronunciation, String example) {
        this.id = id;
        this.word = word;
        this.pseudonym = pseudonym;
        this.definition = definition;
        this.pronunciation = pronunciation;
        this.example = example;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Words() {
        super();
    }

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
        this.word = word == null ? null : word.trim();
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation == null ? null : pronunciation.trim();
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
    }
}