package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;


import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity.FragmentActivity;

import java.net.URL;

public class AlertsPre implements IAlertsPre {

    @Override
    public void FethRSOData(FragmentActivity fragmentRsoActivity) {
        URL urlAdress;
        urlAdress=DownloadRSOData.createUrlAdress("wszystkie", "hydrologiczne");
        DownloadRSOData.fetchRSODataFromWebsite(urlAdress, fragmentRsoActivity);
        urlAdress=DownloadRSOData.createUrlAdress("wszystkie", "informacje-drogowe");
        DownloadRSOData.fetchRSODataFromWebsite(urlAdress, fragmentRsoActivity);
    }
}
