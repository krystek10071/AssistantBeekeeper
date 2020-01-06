package com.example.assistantbeekeeper.weatherwitget;

public class WeatherDataClass {

    private String date;
    private int whetherIcon;
    private String iconPhrase;
    private boolean isDayLight;
    private float currentTemperature;
    private float realFeelTemperature;
    private float windSpeed;
    private int uvIndex;
    private int precipitationProbality;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public boolean isDayLight() {
        return isDayLight;
    }

    public void setDayLight(boolean dayLight) {
        isDayLight = dayLight;
    }

    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(float currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public float getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public void setRealFeelTemperature(float realFeelTemperature) {
        this.realFeelTemperature = realFeelTemperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getPrecipitationProbality() {
        return precipitationProbality;
    }

    public void setPrecipitationProbality(int precipitationProbality) {
        this.precipitationProbality = precipitationProbality;
    }
}
