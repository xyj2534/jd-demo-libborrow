package edu.jd.xyt.lib;

public class LibborrowDto {

    private String L_id;
    private String R_id;
    private String R_name;
    private String B_id;
    private String B_name;
    private String borrowDate;
    private String deadline;
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

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    @Override
    public String toString() {
        return "LibborrowDto{" +
                "L_id='" + L_id + '\'' +
                ", R_id='" + R_id + '\'' +
                ", R_name='" + R_name + '\'' +
                ", B_id='" + B_id + '\'' +
                ", B_name='" + B_name + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", deadline='" + deadline + '\'' +
                ", State=" + State +
                '}';
    }
}
