package com.example.skill_training.entity;

public class WorkOrder {
    private String id;
    private String order_id;//订单id
    private String orderCode;//工单条码
    private String unitName;//计量单位
    private String orderType;//工单类型
    private int amount;//工单生产数量
    private String estStartTime;//预计生产时间
    private String estEndTime;//预计结束时间
    private String actStartTime;//实际生产时间
    private int inAmount;//投入数量
    private int outAmount;//产出数量
    private int scrapAmount;//报废数量
    private String state;//工单状态
    private String line_id;//所属产线
    private String product_id;//产品
    private String del_flag;
    private String remarks;
    private String create_by;
    private String create_date;
    private String update_by;
    private String update_date;
    private String label;

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id='" + id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", unitName='" + unitName + '\'' +
                ", orderType='" + orderType + '\'' +
                ", amount=" + amount +
                ", estStartTime='" + estStartTime + '\'' +
                ", estEndTime='" + estEndTime + '\'' +
                ", actStartTime='" + actStartTime + '\'' +
                ", inAmount=" + inAmount +
                ", outAmount=" + outAmount +
                ", scrapAmount=" + scrapAmount +
                ", state='" + state + '\'' +
                ", line_id='" + line_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", del_flag='" + del_flag + '\'' +
                ", remarks='" + remarks + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_date='" + create_date + '\'' +
                ", update_by='" + update_by + '\'' +
                ", update_date='" + update_date + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEstStartTime() {
        return estStartTime;
    }

    public void setEstStartTime(String estStartTime) {
        this.estStartTime = estStartTime;
    }

    public String getEstEndTime() {
        return estEndTime;
    }

    public void setEstEndTime(String estEndTime) {
        this.estEndTime = estEndTime;
    }

    public String getActStartTime() {
        return actStartTime;
    }

    public void setActStartTime(String actStartTime) {
        this.actStartTime = actStartTime;
    }

    public int getInAmount() {
        return inAmount;
    }

    public void setInAmount(int inAmount) {
        this.inAmount = inAmount;
    }

    public int getOutAmount() {
        return outAmount;
    }

    public void setOutAmount(int outAmount) {
        this.outAmount = outAmount;
    }

    public int getScrapAmount() {
        return scrapAmount;
    }

    public void setScrapAmount(int scrapAmount) {
        this.scrapAmount = scrapAmount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
