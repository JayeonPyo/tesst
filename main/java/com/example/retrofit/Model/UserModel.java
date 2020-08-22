package com.example.retrofit.Model;

import java.util.List;

public class UserModel {
    private String id;
    private String passwd;
    private String email;
    private List<ArticleModel> article;

    public List<ArticleModel> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleModel> article) {
        this.article = article;
    }

    public UserModel(String id, String passwd, String email) {
        this.id = id;
        this.passwd = passwd;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
