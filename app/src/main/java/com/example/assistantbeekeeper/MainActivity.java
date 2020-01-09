package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assistantbeekeeper.weatherwitget.WeatherWidget;

import java.net.URL;

public class MainActivity extends AppCompatActivity {


     Button breedingButton;
     CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL weatherFiveDayData;

        breedingButton= findViewById(R.id.breedingButton);
        breedingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(), Breeding.class);
                startActivity(intent);
            }
        });

        weatherFiveDayData=WeatherWidget.createUrlAddress();
        WeatherWidget.FetchDataWether(weatherFiveDayData);





    }


}
