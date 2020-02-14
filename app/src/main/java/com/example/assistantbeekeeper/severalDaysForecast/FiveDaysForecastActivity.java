package com.example.assistantbeekeeper.severalDaysForecast;


import android.os.Bundle;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FiveDaysForecastActivity extends AppCompatActivity implements IFiveDaysForecastActivity {

    TextView weekday1, weekday2, weekday3, weekday4, weekday5;
    TextView describeWeather1, describeWeather2, describeWeather3, describeWeather4, describeWeather5;
    TextView tDay1, tDay2, tDay3, tDay4, tDay5;
    TextView tNight1, tNight2, tNight3, tNight4, tNight5;
    TextView windSpeed1, windSpeed2, windSpeed3, windSpeed4, windSpeed5;
    FiveDaysForecast fiveDaysForecast=new FiveDaysForecast();


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_days_forecast);

        //init TextView components
        initComponentView();
        fiveDaysForecast.downloadWeatherData(this);




    }


    @Override
    public void initComponentView() {
        weekday1=findViewById(R.id.weekDay1);
        weekday2=findViewById(R.id.weekday2);
        weekday3=findViewById(R.id.weekday3);
        weekday4=findViewById(R.id.weekday4);
        weekday5=findViewById(R.id.weekday5);
        describeWeather1=findViewById(R.id.describe_weather_icon1);
        describeWeather2=findViewById(R.id.describe_weather_icon2);
        describeWeather3=findViewById(R.id.describe_weather_icon3);
        describeWeather4=findViewById(R.id.describe_weather_icon4);
        describeWeather5=findViewById(R.id.describe_weather_icon5);
        tDay1=findViewById(R.id.t_day1);
        tDay2=findViewById(R.id.t_day2);
        tDay3=findViewById(R.id.t_day3);
        tDay4=findViewById(R.id.t_day4);
        tDay5=findViewById(R.id.t_day5);
        tNight1=findViewById(R.id.t_night1);
        tNight2=findViewById(R.id.t_night2);
        tNight3=findViewById(R.id.t_night3);
        tNight4=findViewById(R.id.t_night4);
        tNight5=findViewById(R.id.t_night5);
        windSpeed1=findViewById(R.id.wind_speed1);
        windSpeed2=findViewById(R.id.wind_speed2);
        windSpeed3=findViewById(R.id.wind_speed3);
        windSpeed4=findViewById(R.id.wind_speed4);
        windSpeed5=findViewById(R.id.wind_speed5);
    }


    public void setData(ArrayList<FiveDayWeatherDataClass> data) {

        describeWeather1.setText(data.get(0).getIconPhrase());

    }


}
