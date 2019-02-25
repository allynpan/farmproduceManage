package com.pyl.demo.model;

public class TECHB_info {
    private Integer id;

    private String plantName;

    private String suitableTem;

    private String suitableLight;

    private String suitableLand;

    private String suitableWater;

    private String shootTime;

    private String shootStatue;

    private String blossomTime;

    private String blossomStatue;

    private String fruitTime;

    private String fruitStatue;

    private String matureTime;

    private String matureStatue;

    private String remark;

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

    public String getSuitableTem() {
        return suitableTem;
    }

    public void setSuitableTem(String suitableTem) {
        this.suitableTem = suitableTem == null ? null : suitableTem.trim();
    }

    public String getSuitableLight() {
        return suitableLight;
    }

    public void setSuitableLight(String suitableLight) {
        this.suitableLight = suitableLight == null ? null : suitableLight.trim();
    }

    public String getSuitableLand() {
        return suitableLand;
    }

    public void setSuitableLand(String suitableLand) {
        this.suitableLand = suitableLand == null ? null : suitableLand.trim();
    }

    public String getSuitableWater() {
        return suitableWater;
    }

    public void setSuitableWater(String suitableWater) {
        this.suitableWater = suitableWater == null ? null : suitableWater.trim();
    }

    public String getShootTime() {
        return shootTime;
    }

    public void setShootTime(String shootTime) {
        this.shootTime = shootTime == null ? null : shootTime.trim();
    }

    public String getShootStatue() {
        return shootStatue;
    }

    public void setShootStatue(String shootStatue) {
        this.shootStatue = shootStatue == null ? null : shootStatue.trim();
    }

    public String getBlossomTime() {
        return blossomTime;
    }

    public void setBlossomTime(String blossomTime) {
        this.blossomTime = blossomTime == null ? null : blossomTime.trim();
    }

    public String getBlossomStatue() {
        return blossomStatue;
    }

    public void setBlossomStatue(String blossomStatue) {
        this.blossomStatue = blossomStatue == null ? null : blossomStatue.trim();
    }

    public String getFruitTime() {
        return fruitTime;
    }

    public void setFruitTime(String fruitTime) {
        this.fruitTime = fruitTime == null ? null : fruitTime.trim();
    }

    public String getFruitStatue() {
        return fruitStatue;
    }

    public void setFruitStatue(String fruitStatue) {
        this.fruitStatue = fruitStatue == null ? null : fruitStatue.trim();
    }

    public String getMatureTime() {
        return matureTime;
    }

    public void setMatureTime(String matureTime) {
        this.matureTime = matureTime == null ? null : matureTime.trim();
    }

    public String getMatureStatue() {
        return matureStatue;
    }

    public void setMatureStatue(String matureStatue) {
        this.matureStatue = matureStatue == null ? null : matureStatue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TECHB_info{" +
                "id=" + id +
                ", plantName='" + plantName + '\'' +
                ", suitableTem='" + suitableTem + '\'' +
                ", suitableLight='" + suitableLight + '\'' +
                ", suitableLand='" + suitableLand + '\'' +
                ", suitableWater='" + suitableWater + '\'' +
                ", shootTime='" + shootTime + '\'' +
                ", shootStatue='" + shootStatue + '\'' +
                ", blossomTime='" + blossomTime + '\'' +
                ", blossomStatue='" + blossomStatue + '\'' +
                ", fruitTime='" + fruitTime + '\'' +
                ", fruitStatue='" + fruitStatue + '\'' +
                ", matureTime='" + matureTime + '\'' +
                ", matureStatue='" + matureStatue + '\'' +
                '}';
    }

}