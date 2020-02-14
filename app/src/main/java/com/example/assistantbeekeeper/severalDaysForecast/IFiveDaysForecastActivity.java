package com.example.assistantbeekeeper.severalDaysForecast;


import android.app.Activity;

import java.util.ArrayList;

public interface IFiveDaysForecastActivity {
    void initComponentView();
    void setData(ArrayList<FiveDayWeatherDataClass> data);
}
