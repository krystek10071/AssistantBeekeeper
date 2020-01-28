package com.example.assistantbeekeeper.weatherwitget;

public class WeatherDataGeneral {
    private long epochDate;
    private String location;
    private int whetherIcon;
    private String iconPhrase;
    private double temperature;
    private double realFeelTemperature;
    private double windSpeed;
    private int precipitationProbality;


     WeatherDataGeneral( long epochDate, String location, int whetherIcon, String iconPhrase,
                              double temperature, double realFeelTemperature, double windSpeed, int precipitationProbality) {

        this.epochDate = epochDate;
        this.location = location;
        this.whetherIcon = whetherIcon;
        this.iconPhrase = iconPhrase;
        this.temperature = temperature;
        this.realFeelTemperature = realFeelTemperature;
        this.windSpeed = windSpeed;
        this.precipitationProbality = precipitationProbality;
    }

    public long getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(long epochDate) {
        this.epochDate = epochDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getWhetherIcon() {
        return whetherIcon;
    }

    public void setWhetherIcon(int whetherIcon) {
        this.whetherIcon = whetherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public double getCurrentTemperature() {
        return temperature;
    }

    public void setCurrentTemperature(float currentTemperature) {
        this.temperature = currentTemperature;
    }

    public double getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public void setRealFeelTemperature(float realFeelTemperature) {
        this.realFeelTemperature = realFeelTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }


    public int getPrecipitationProbality() {
        return precipitationProbality;
    }

    public void setPrecipitationProbality(int precipitationProbality) {
        this.precipitationProbality = precipitationProbality;
    }
}
