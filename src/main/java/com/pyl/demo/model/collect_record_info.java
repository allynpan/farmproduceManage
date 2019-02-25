package com.pyl.demo.model;

import java.util.Date;

public class collect_record_info {
    private Integer id;

    private String plantName;

    private String plantation;

    private String rulesCollect;

    private Byte isFinish;

    private Date dealTime;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName == null ? null : plantName.trim();
    }

    public String getPlantation() {
        return plantation;
    }

    public void setPlantation(String plantation) {
        this.plantation = plantation == null ? null : plantation.trim();
    }

    public String getRulesCollect() {
        return rulesCollect;
    }

    public void setRulesCollect(String rulesCollect) {
        this.rulesCollect = rulesCollect == null ? null : rulesCollect.trim();
    }

    public Byte getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Byte isFinish) {
        this.isFinish = isFinish;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}