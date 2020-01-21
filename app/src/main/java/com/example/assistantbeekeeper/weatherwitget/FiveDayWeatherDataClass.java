package com.example.assistantbeekeeper.weatherwitget;

public class FiveDayWeatherDataClass extends WeatherDataGeneral {


    public FiveDayWeatherDataClass( long epochDate, String location, int whetherIcon, String iconPhrase, double temperature,
                                   double realFeelTemperature, double windSpeed, int precipitationProbality) {
        super( epochDate, location, whetherIcon, iconPhrase, temperature,
                realFeelTemperature, windSpeed, precipitationProbality);
    }
}
