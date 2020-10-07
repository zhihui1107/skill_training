package com.example.skill_training.entity;

public class Bom {
    private String id;
    private String bomName;
    private String bomVersion;
    private String product_id;
    private String status;
    private String create_by;
    private String create_date;
    private String update_by;
    private String update_date;
    private String remarks;
    private String del_flag;

    @Override
    public String toString() {
        return "Bom{" +
                "id='" + id + '\'' +
                ", bomName='" + bomName + '\'' +
                ", bomVersion='" + bomVersion + '\'' +
                ", product_id='" + product_id + '\'' +
                ", status='" + status + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_date='" + create_date + '\'' +
                ", update_by='" + update_by + '\'' +
                ", update_date='" + update_date + '\'' +
                ", remarks='" + remarks + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBomName() {
        return bomName;
    }

    public void setBomName(String bomName) {
        this.bomName = bomName;
    }

    public String getBomVersion() {
        return bomVersion;
    }

    public void setBomVersion(String bomVersion) {
        this.bomVersion = bomVersion;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }
}
