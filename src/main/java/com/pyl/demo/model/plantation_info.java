package com.pyl.demo.model;

public class plantation_info {
    private Integer id;

    private String plantation;

    private String terrainPlantation;

    private String temperature;

    private String address;

    private String humidity;

    private String salinity;

    private String ph;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantation() {
        return plantation;
    }

    public void setPlantation(String plantation) {
        this.plantation = plantation == null ? null : plantation.trim();
    }

    public String getTerrainPlantation() {
        return terrainPlantation;
    }

    public void setTerrainPlantation(String terrainPlantation) {
        this.terrainPlantation = terrainPlantation == null ? null : terrainPlantation.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}