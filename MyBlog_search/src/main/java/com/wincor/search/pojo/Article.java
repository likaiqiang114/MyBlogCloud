package com.wincor.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "tensquare_article",type ="article" )
public class Article implements Serializable {
    @Id
    private String id;

    //关于@Field的三个概念
    //是否索引，表示该域是否能被搜索内容匹配到
    //是否分词，表示该域在搜索时，是输入的搜索内容用整体匹配还是搜索内容分词后用单词匹配到
    //是否存储，就是是否在页面上显示
    @Field(index = true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index = true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//这里是内容变量，本来应该是描述变量（描述变量当然需要存储，其他无争议），因为数据库没有，所以用内容变量临时代替

    private String state;//审核状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
