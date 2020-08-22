package com.example.retrofit.Model;

import java.util.Date;
import java.util.List;

public class ArticleModel {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }
    private String id;
    private String passwd;
    private String text;
    private Date date;
    private String option;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public ArticleModel(Date date, String option) {
        this.date = date;
        this.option = option;
    }

    public ArticleModel(String id, String passwd, String text, List<String> comment) {
        this.id = id;
        this.passwd = passwd;
        this.text = text;
        this.comment = comment;
    }

    private List<String> comment;

}
