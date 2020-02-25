package com.example.assistantbeekeeper.severalDaysForecast.severalDaysPre;



import com.example.assistantbeekeeper.severalDaysForecast.severalDaysActivity.FiveDaysForecastActivity;

import java.net.URL;


public class FiveDaysForecast implements IFiveDaysForecast {


    @Override
    public void downloadWeatherData(FiveDaysForecastActivity fiveDaysForecastActivity) {
        //create url address
        URL myUrl= DownloadData.createUrlAdress();
        //fetch data from webservice
        DownloadData.FetchDataFromWebside(myUrl, fiveDaysForecastActivity);

    }
}
