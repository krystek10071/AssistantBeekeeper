package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.assistantbeekeeper.weatherwitget.CurrentWeatherDataClass;
import com.example.assistantbeekeeper.weatherwitget.WeatherWidget;
import com.example.assistantbeekeeper.severalDaysForecast.FiveDaysForecastActivity;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    //UI Elementsr
     Button breedingButton;
     Button fiveDaysForecast;
     TextView currentLocation;
     TextView currentTemperature;
     TextView describeWeatherIcon;
     TextView windSpeed;
     TextView pop;
     TextView sensibleTemperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL weatherOneDayData;
        ArrayList<CurrentWeatherDataClass>  listWeatherOneDay;
        currentLocation=findViewById(R.id.current_location);
        currentTemperature=findViewById(R.id.current_temperature);
        describeWeatherIcon=findViewById(R.id.describe_weather_Icon);
        windSpeed=findViewById(R.id.wind_speed);
        pop=findViewById(R.id.POP);
        sensibleTemperature=findViewById(R.id.sensible_temperature);
        fiveDaysForecast=findViewById(R.id.five_days_forecast_button);


        breedingButton= findViewById(R.id.breedingButton);
        breedingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(), Breeding.class);
                startActivity(intent);
            }
        });

        fiveDaysForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), FiveDaysForecastActivity.class);
                startActivity(intent);
            }
        });



        weatherOneDayData=WeatherWidget.createUrlAddress();
        listWeatherOneDay=WeatherWidget.FetchDataWether(weatherOneDayData,this);

    }


}
