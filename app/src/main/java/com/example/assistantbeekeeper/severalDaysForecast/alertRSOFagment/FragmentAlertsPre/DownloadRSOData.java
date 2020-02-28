package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;

import android.os.AsyncTask;
import android.util.Log;

import com.example.assistantbeekeeper.weatherwitget.NetworkUtils;

import java.net.URL;

public class DownloadRSOData {

    private static final String TAG="DownloadRsoData";

    public static URL createUrlAdress(String provincy, String category){
        URL buildURLRSO=NetworkUrlAdress.buildRsoAdress(provincy, category);
        return buildURLRSO;
    }

    public static void fetchRSODataFromWebsite(URL url){
       new DownloadRSODetails().execute(url);
    }

    public static class DownloadRSODetails extends AsyncTask<URL, Void, String>{


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
            }

            Log.i(TAG, "RSO Data result" + resultRSOData);
            return resultRSOData;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Todo
        }
    }
}
