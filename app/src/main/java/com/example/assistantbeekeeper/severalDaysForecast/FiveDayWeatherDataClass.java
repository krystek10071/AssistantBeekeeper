package com.example.assistantbeekeeper.severalDaysForecast;

import com.example.assistantbeekeeper.weatherwitget.WeatherDataGeneral;

public class FiveDayWeatherDataClass  {

    private long epochDate;
    private int weatherIcon;
    private String iconPhrase;
    private double tDay;
    private double tNight;
    private double windSpeed;

    public FiveDayWeatherDataClass(long epochDate, int weatherIcon, String iconPhrase, double tDay, double tNight, double windSpeed) {
        this.epochDate = epochDate;
        this.weatherIcon = weatherIcon;
        this.iconPhrase = iconPhrase;
        this.tDay = tDay;
        this.tNight = tNight;
        this.windSpeed = windSpeed;
    }

    public long getEpochDate() {
        return epochDate;
    }

    public void setEpochDate(long epochDate) {
        this.epochDate = epochDate;
    }

    public int getWheatherIcon() {
        return weatherIcon;
    }

    public void setWheatherIcon(int wheatherIcon) {
        this.weatherIcon = wheatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public double gettDay() {
        return tDay;
    }

    public void settDay(double tDay) {
        this.tDay = tDay;
    }

    public double gettNight() {
        return tNight;
    }

    public void settNight(double tNight) {
        this.tNight = tNight;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
