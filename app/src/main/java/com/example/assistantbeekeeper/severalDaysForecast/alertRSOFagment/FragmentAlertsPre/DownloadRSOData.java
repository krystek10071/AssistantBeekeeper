package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.DataModel.AlertsWeatherData;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity.FragmentActivity;
import com.example.assistantbeekeeper.weatherwitget.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

public class DownloadRSOData {

    private static final String TAG="DownloadRsoData";

    public static URL createUrlAdress(String provincy, String category){
        URL buildURLRSO=NetworkUrlAdress.buildRsoAdress(provincy, category);
        return buildURLRSO;
    }

    public static void fetchRSODataFromWebsite(URL url, FragmentActivity fragmentActivity){

        new DownloadRSODetails(fragmentActivity).execute(url);
    }

    public static class DownloadRSODetails extends AsyncTask<URL, Void, String>{

        private FragmentActivity fragmentActivity;

        public DownloadRSODetails(FragmentActivity fragmentActivity){
            this.fragmentActivity=fragmentActivity;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         *
         * @param urls adress to WebsSite with Data
         * @return String resultRSOData with RSO messages
         */

        @Override
        protected String doInBackground(URL... urls) {
            URL urlAdress=urls[0];
            String resultRSOData=null;

            try{
                resultRSOData=NetworkUtils.getResponseFromUrl(urlAdress);
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }

            Log.i(TAG, "RSO Data result" + resultRSOData);
            return resultRSOData;
        }

        @Override
        protected void onPostExecute(String result) {
            FragmentActivity fragmentRso=fragmentActivity;
            ArrayList<AlertsWeatherData> alertsResultList;
            RSOParserJsonData parserJsonData= new RSOParserJsonData(result);
            alertsResultList=parserJsonData.ParseJsonToListObj();

            fragmentRso.setRecycleView(alertsResultList);

            if(alertsResultList.isEmpty()){
                fragmentRso.displayMessage();
            }
        }
    }
}
