package edu.jd.xyt.lib;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Libborrow {

    private String L_id;
    private String R_id;
    private String R_name;
    private String B_id;
    private String B_name;
    private Date borrowDate;
    private Date deadline;
    private Integer State; // 1 已还书 2 未还书


    public String getL_id() {
        return L_id;
    }

    public void setL_id(String l_id) {
        L_id = l_id;
    }

    public String getR_id() {
        return R_id;
    }

    public void setR_id(String r_id) {
        R_id = r_id;
    }

    public String getR_name() {
        return R_name;
    }

    public void setR_name(String r_name) {
        R_name = r_name;
    }

    public String getB_id() {
        return B_id;
    }

    public void setB_id(String b_id) {
        B_id = b_id;
    }

    public String getB_name() {
        return B_name;
    }

    public void setB_name(String b_name) {
        B_name = b_name;
    }

    @JSONField(format = "yyyy-MM-dd")
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @JSONField(format = "yyyy-MM-dd")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
