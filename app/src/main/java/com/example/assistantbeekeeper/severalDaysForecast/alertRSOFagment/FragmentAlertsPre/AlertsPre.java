package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;


import java.net.URL;

public class AlertsPre implements IAlertsPre {

    @Override
    public void FethRSOData() {
        URL urlAdress;
        urlAdress=DownloadRSOData.createUrlAdress("lubelskie", "informacje-drogowe");
        DownloadRSOData.fetchRSODataFromWebsite(urlAdress);
    }
}
