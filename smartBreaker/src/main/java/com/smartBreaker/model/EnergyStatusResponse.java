package com.smartBreaker.model;

public class EnergyStatusResponse {
    private String status;
    private String weatherDescription;
    private double temperature;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
