package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;


import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.DataModel.AlertsWeatherData;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity.FragmentActivity;

import java.net.URL;
import java.util.ArrayList;

public class AlertsPre implements IAlertsPre {

    @Override
    public void FethRSOData(FragmentActivity fragmentRsoActivity) {
        URL urlAdress;
        //todo

        urlAdress=DownloadRSOData.createUrlAdress("lubelskie", "ogolne");
        DownloadRSOData.fetchRSODataFromWebsite(urlAdress, fragmentRsoActivity);
        //urlAdress=DownloadRSOData.createUrlAdress("wszystkie", "informacje-drogowe");
        //DownloadRSOData.fetchRSODataFromWebsite(urlAdress, fragmentRsoActivity);
    }
}
