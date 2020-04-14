package com.example.assistantbeekeeper.Breeding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.Breeding.Breeding;
import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.panelAddApiary.addApiaryActivity.AddApiaryActivity;
import com.example.assistantbeekeeper.panelButtonFragment.panelButtonActivity.PanelButtonActivity;

import com.example.assistantbeekeeper.statisticsProduction.FragmentActivity.StatisticGeneralFragment;
import com.example.assistantbeekeeper.weatherRadar.weatherRadarActi.WeatherRadarActivity;
import com.example.assistantbeekeeper.weatherwitget.CurrentWeatherDataClass;
import com.example.assistantbeekeeper.severalDaysForecast.severalDaysActivity.FiveDaysForecastActivity;
import com.example.assistantbeekeeper.weatherwitget.WeatherWidget;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements StatisticGeneralFragment.OverviewFragmentActivityListener {

    private static final String TAG="MainActivity";

    //UI Elements
     Button breedingButton;
     Button fiveDaysForecast;
     Button buttonTest;
     Button addApiaryButton;
     TextView currentLocation;
     TextView currentTemperature;
     TextView describeWeatherIcon;
     TextView windSpeed;
     TextView pop;
     TextView sensibleTemperature;
     ImageView weatherIcon;
     PanelButtonActivity fragmentPanelButtons;
     FusedLocationProviderClient fusedLocationProviderClient;
     String nameProvince;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkMyLocation();


        breedingButton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), Breeding.class);
            startActivity(intent);
        });

        fiveDaysForecast.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), FiveDaysForecastActivity.class);
            intent.putExtra("province", nameProvince);
            startActivity(intent);
        });

        buttonTest.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), WeatherRadarActivity.class);
            startActivity(intent);
        });

        addApiaryButton.setOnClickListener(view ->{
            Intent intent=new Intent(getApplicationContext(), AddApiaryActivity.class);
            startActivity(intent);
        } );


        //todo

      // weatherOneDayData= WeatherWidget.createUrlAddress(myAdresses);
       //listWeatherOneDay=WeatherWidget.FetchDataWether(weatherOneDayData,this, this);
       //FragmentActivity fragmentStatistics= (FragmentActivity) getSupportFragmentManager().findFragmentById(R.id.statistics_fragment);
    }

    public void createCurrentWeatherForecast(int keyLocation){
       URL weatherUrlOneDayData= WeatherWidget.createUrlAddress(keyLocation);
        ArrayList<CurrentWeatherDataClass> listWeatherOneDay = WeatherWidget.FetchDataWether(weatherUrlOneDayData, this, this);
    }


    private void checkMyLocation() {
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)==
                PackageManager.PERMISSION_GRANTED){
            getLocation();
        }else
        {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                    44);
        }

    }

    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(task -> {
            Location location = task.getResult();
            if (location != null) {
                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());

                try {
                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),
                            1);

                    WeatherWidget.fetchLocationKey(MainActivity.this, addresses);
                    currentLocation.setText(addresses.get(0).getLocality());
                    nameProvince=addresses.get(0).getAdminArea();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }





    private void init(){
        currentLocation=findViewById(R.id.current_location);
        currentTemperature=findViewById(R.id.current_temperature);
        describeWeatherIcon=findViewById(R.id.describe_weather_Icon);
        windSpeed=findViewById(R.id.wind_speed);
        pop=findViewById(R.id.POP);
        sensibleTemperature=findViewById(R.id.sensible_temperature);
        fiveDaysForecast=findViewById(R.id.five_days_forecast_button);
        breedingButton= findViewById(R.id.breedingButton);
        weatherIcon=findViewById(R.id.icon_weather);
        buttonTest=findViewById(R.id.buttonTest);
        fragmentPanelButtons=(PanelButtonActivity) getSupportFragmentManager().findFragmentById(R.id.panel_button_fragment);
        addApiaryButton=findViewById(R.id.addApiaryButton);
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);

    }

    public void setWeatherIcon(ArrayList<CurrentWeatherDataClass> data, int index){
        weatherIcon.setImageDrawable(getResForWeatherIcon(data, index));
    }

    private Drawable getResForWeatherIcon(ArrayList<CurrentWeatherDataClass> data, int index) {

        if(data.get(index).getWeatherIcon()==1 || data.get(index).getWeatherIcon()==2 || data.get(index).getWeatherIcon()==3 ){
            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_partly_cloudy, null);
        }


        else if(data.get(index).getWeatherIcon()==4 || data.get(index).getWeatherIcon()==5 || data.get(index).getWeatherIcon()==6){
            //mostly cloud
            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_partly_cloudy, null);

        }

        else if(data.get(index).getWeatherIcon()==7 || data.get(index).getWeatherIcon()==8 || data.get(index).getWeatherIcon()==11){
            //cloud
            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_overcast, null);
        }

        else if(data.get(index).getWeatherIcon()==12 || data.get(index).getWeatherIcon()==13 || data.get(index).getWeatherIcon()==14)
        {
            //showers
            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_showers, null);

        }

        else if(data.get(index).getWeatherIcon()==18){
            //rain

            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_rain_icon, null);
        }

        else if(data.get(index).getWeatherIcon()==25 || data.get(index).getWeatherIcon()==26 || data.get(index).getWeatherIcon()==29){
            //rain && snow
            return ResourcesCompat.getDrawable(getResources(),R.drawable.iconfinder_foggy_3741362, null);
        }

        return null;
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if(fragment instanceof StatisticGeneralFragment){
            StatisticGeneralFragment statisticGeneralFragment=(StatisticGeneralFragment) fragment;
            statisticGeneralFragment.setOverviewFragmentActivityListener(this);
        }
    }

    @Override
    public void sendIdApiaryToPanelButton(String name_apiary) {
       // Toast.makeText(this, name_apiary, Toast.LENGTH_LONG).show();
        fragmentPanelButtons.setNameApiary(name_apiary);
    }
}
