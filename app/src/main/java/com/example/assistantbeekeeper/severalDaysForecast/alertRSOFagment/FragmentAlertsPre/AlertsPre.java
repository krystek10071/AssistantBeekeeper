package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;


import java.net.URL;

public class AlertsPre implements IAlertsPre {

    @Override
    public void FethRSOData() {
        URL urlAdress;
        urlAdress=DownloadRSOData.createUrlAdress("wszystkie", "informacje-drogowe");
        DownloadRSOData.fetchRSODataFromWebsite(urlAdress);
    }
}
