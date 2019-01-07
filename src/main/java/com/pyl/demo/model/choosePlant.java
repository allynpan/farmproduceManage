package com.pyl.demo.model;

import java.util.Date;

public class choosePlant {
    private String plantation;//产园名
    private String plant;//农产品名
    private Date time;

    public String getPlantation() {
        return plantation;
    }

    public void setPlantation(String plantation) {
        this.plantation = plantation;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "choosePlant{" +
                "plantation='" + plantation + '\'' +
                ", plant='" + plant + '\'' +
                ", time=" + time +
                '}';
    }



}
