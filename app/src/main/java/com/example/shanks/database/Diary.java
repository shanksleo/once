package com.example.shanks.database;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by shanks on 14/12/30.
 */
public class Diary extends DataSupport{
    private int id;
    private Date createDate;
    private Date modifyDate;
    private String title;
    private String comment;
    private String article;

    public Diary(Date createDate, Date modifyDate, String title, String comment, String article) {
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.title = title;
        this.comment = comment;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
