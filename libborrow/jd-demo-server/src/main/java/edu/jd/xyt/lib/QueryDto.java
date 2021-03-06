package edu.jd.xyt.lib;

import edu.jd.xyt.common.paraParam;

public class QueryDto extends paraParam {

    private String L_id;
    private String R_id;
    private String R_name;
    private String B_id;
    private String B_name;
    private String start_borrowDate;
    private String end_borrowDate;

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

    public String getStart_borrowDate() {
        return start_borrowDate;
    }

    public void setStart_borrowDate(String start_borrowDate) {
        this.start_borrowDate = start_borrowDate;
    }

    public String getEnd_borrowDate() {
        return end_borrowDate;
    }

    public void setEnd_borrowDate(String end_borrowDate) {
        this.end_borrowDate = end_borrowDate;
    }
}