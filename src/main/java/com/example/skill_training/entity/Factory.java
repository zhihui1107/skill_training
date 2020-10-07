package com.example.skill_training.entity;

public class Factory {
    private String id;
    private String factoryName;
    private String factoryBuildDate;
    private String factoryAddress;
    private String factoryPhone;
    private String factoryECode;
    private String factoryBuildM;
    private String enterprise_id;
    private String del_flag;
    private String remarks;
    private String create_by;
    private String create_date;
    private String update_by;
    private String update_date;
    private String enterName;

    @Override
    public String toString() {
        return "Factory{" +
                "id='" + id + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", factoryBuildDate='" + factoryBuildDate + '\'' +
                ", factoryAddress='" + factoryAddress + '\'' +
                ", factoryPhone='" + factoryPhone + '\'' +
                ", factoryECode='" + factoryECode + '\'' +
                ", factoryBuildM='" + factoryBuildM + '\'' +
                ", enterprise_id='" + enterprise_id + '\'' +
                ", del_flag='" + del_flag + '\'' +
                ", remarks='" + remarks + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_date='" + create_date + '\'' +
                ", update_by='" + update_by + '\'' +
                ", update_date='" + update_date + '\'' +
                ", enterName='" + enterName + '\'' +
                '}';
    }

    public String getEnterName() {
        return enterName;
    }

    public void setEnterName(String enterName) {
        this.enterName = enterName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryBuildDate() {
        return factoryBuildDate;
    }

    public void setFactoryBuildDate(String factoryBuildDate) {
        this.factoryBuildDate = factoryBuildDate;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getFactoryPhone() {
        return factoryPhone;
    }

    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone;
    }

    public String getFactoryECode() {
        return factoryECode;
    }

    public void setFactoryECode(String factoryECode) {
        this.factoryECode = factoryECode;
    }

    public String getFactoryBuildM() {
        return factoryBuildM;
    }

    public void setFactoryBuildM(String factoryBuildM) {
        this.factoryBuildM = factoryBuildM;
    }

    public String getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

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
}
