package com.pyl.demo.model;

import java.util.Date;

public class disease_record_info {
    private Integer id;

    private String place;

    private Double square;

    private Integer num;

    private Integer diseaseNum;

    private Double diseaseRate;

    private String insectName;

    private Date time;

    private Integer userId;

    private String name;

    private Byte isFinish;

    private Date protectTime;

    private String medicine;

    private Double dosage;

    private String result;

    private String executor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDiseaseNum() {
        return diseaseNum;
    }

    public void setDiseaseNum(Integer diseaseNum) {
        this.diseaseNum = diseaseNum;
    }

    public Double getDiseaseRate() {
        return diseaseRate;
    }

    public void setDiseaseRate(Double diseaseRate) {
        this.diseaseRate = diseaseRate;
    }

    public String getInsectName() {
        return insectName;
    }

    public void setInsectName(String insectName) {
        this.insectName = insectName == null ? null : insectName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Byte isFinish) {
        this.isFinish = isFinish;
    }

    public Date getProtectTime() {
        return protectTime;
    }

    public void setProtectTime(Date protectTime) {
        this.protectTime = protectTime;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor == null ? null : executor.trim();
    }

    @Override
    public String toString() {
        return "disease_record_info{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", square=" + square +
                ", num=" + num +
                ", diseaseNum=" + diseaseNum +
                ", diseaseRate=" + diseaseRate +
                ", insectName='" + insectName + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", isFinish=" + isFinish +
                ", protectTime=" + protectTime +
                ", medicine='" + medicine + '\'' +
                ", dosage=" + dosage +
                ", result='" + result + '\'' +
                ", executor='" + executor + '\'' +
                '}';
    }
}