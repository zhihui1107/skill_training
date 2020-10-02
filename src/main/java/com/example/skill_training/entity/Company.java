package com.example.skill_training.entity;

public class Company {
    private String id;
    private String enterName;//企业名称
    private String enterCode;//组织机构代码
    private String enterLevel;//企业层级
    private String enterNature;//企业性质
    private String enterCapital;//注册资本
    private String enterLperson;//法人
    private String enterLpCard;//法人身份证
    private String enterAddress;//地址
    private String emailCode;//邮政编码
    private String enterRemarks;//备注
    private String del_flag;
    private String remarks;
    private String create_by;
    private String create_date;
    private String update_by;
    private String update_date;

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getEnterCode() {
        return enterCode;
    }

    public void setEnterCode(String enterCode) {
        this.enterCode = enterCode;
    }

    public String getEnterLevel() {
        return enterLevel;
    }

    public void setEnterLevel(String enterLevel) {
        this.enterLevel = enterLevel;
    }

    public String getEnterNature() {
        return enterNature;
    }

    public void setEnterNature(String enterNature) {
        this.enterNature = enterNature;
    }

    public String getEnterCapital() {
        return enterCapital;
    }

    public void setEnterCapital(String enterCapital) {
        this.enterCapital = enterCapital;
    }

    public String getEnterLperson() {
        return enterLperson;
    }

    public void setEnterLperson(String enterLperson) {
        this.enterLperson = enterLperson;
    }

    public String getEnterLpCard() {
        return enterLpCard;
    }

    public void setEnterLpCard(String enterLpCard) {
        this.enterLpCard = enterLpCard;
    }

    public String getEnterAddress() {
        return enterAddress;
    }

    public void setEnterAddress(String enterAddress) {
        this.enterAddress = enterAddress;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getEnterRemarks() {
        return enterRemarks;
    }

    public void setEnterRemarks(String enterRemarks) {
        this.enterRemarks = enterRemarks;
    }
}
