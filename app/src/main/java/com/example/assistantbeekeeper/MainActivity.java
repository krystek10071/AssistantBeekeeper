package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.assistantbeekeeper.weatherwitget.CurrentWeatherDataClass;
import com.example.assistantbeekeeper.weatherwitget.WeatherDataGeneral;
import com.example.assistantbeekeeper.weatherwitget.WeatherWidget;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     Button breedingButton;
     CardView cardView;
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




        breedingButton= findViewById(R.id.breedingButton);
        breedingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(), Breeding.class);
                startActivity(intent);
            }
        });

        weatherOneDayData=WeatherWidget.createUrlAddress();
        listWeatherOneDay=WeatherWidget.FetchDataWether(weatherOneDayData);






    }


}
