package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;


import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity.FragmentActivity;

import java.net.URL;
import java.util.ArrayList;

public class AlertsPre implements IAlertsPre {

    @Override
    public void FethRSOData(FragmentActivity fragmentRsoActivity) {

        //todo
       ArrayList<String> listParameter=new ArrayList<>();
       ArrayList<URL> listUrl=new ArrayList<>();

        listParameter.add("ogolne");
        listParameter.add("meteorologiczne");
        listParameter.add("hydrologiczne");
        listParameter.add("informacje-drogowe");

        int lenghtListParameter=listParameter.size();

        for (int i=0; i<lenghtListParameter; i++){
            URL urlAdress;
            urlAdress=DownloadRSOData.createUrlAdress("wszystkie", listParameter.get(i));
            listUrl.add(urlAdress);
        }

        DownloadRSOData.fetchRSODataFromWebsite(listUrl, fragmentRsoActivity);

    }
}
