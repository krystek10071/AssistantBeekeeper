package com.example.assistantbeekeeper.severalDaysForecast;


import android.app.Activity;
import android.content.Context;

import java.net.URL;


public class FiveDaysForecast implements IFiveDaysForecast{


    @Override
    public void downloadWeatherData(Context context) {
        //create url address
        URL myUrl=DownloadData.createUrlAdress();
        //fetch data from webservice
        DownloadData.FetchDataFromWebside(myUrl, context);

    }
}
