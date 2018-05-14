package com.xiaoyou.domain.user;

public class EngineerDomain {
    private int engineer_id;
    private String user_name;
    private String skill_name;
    private String certificate;
    private int status_mark;
    private String register_time;

    public int getEngineer_id() {
        return engineer_id;
    }

    public void setEngineer_id(int engineer_id) {
        this.engineer_id = engineer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getStatus_mark() {
        return status_mark;
    }

    public void setStatus_mark(int status_mark) {
        this.status_mark = status_mark;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    @Override
    public String toString() {
        return "EngineerDomain{" +
                "engineer_id=" + engineer_id +
                ", user_id=" + user_name +
                ", skill_name='" + skill_name + '\'' +
                ", certificate='" + certificate + '\'' +
                ", status_mark=" + status_mark +
                ", register_time='" + register_time + '\'' +
                '}';
    }

    public EngineerDomain(int engineer_id, String user_name, String skill_name, String certificate, int status_mark, String register_time) {
        this.engineer_id = engineer_id;
        this.user_name = user_name;
        this.skill_name = skill_name;
        this.certificate = certificate;
        this.status_mark = status_mark;
        this.register_time = register_time;
    }

    public EngineerDomain() {
    }
}