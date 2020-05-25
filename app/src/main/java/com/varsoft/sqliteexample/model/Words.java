package com.varsoft.sqliteexample.model;

public class Words {
    private int id;
    private String tr;
    private String en;
    private String insertdate;
    private String updatedate;

    public Words() {
    }


    public Words(int id, String tr, String en, String insertdate, String updatedate) {
        this.id = id;
        this.tr = tr;
        this.en = en;
        this.insertdate = insertdate;
        this.updatedate = updatedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(String insertdate) {
        this.insertdate = insertdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

}
