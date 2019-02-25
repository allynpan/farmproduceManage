package com.pyl.demo.model;

public class plant_info {
    private Integer id;

    private String plantName;

    private String terrain;

    private String maturationTime;

    private String temperature;

    private String humidity;

    private String salinity;

    private String ph;


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

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain == null ? null : terrain.trim();
    }

    public String getMaturationTime() {
        return maturationTime;
    }

    public void setMaturationTime(String maturationTime) {
        this.maturationTime = maturationTime == null ? null : maturationTime.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }

    public String getSalinity() {
        return salinity;
    }

    public void setSalinity(String salinity) {
        this.salinity = salinity == null ? null : salinity.trim();
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

}