package com.example.assistantbeekeeper.severalDaysForecast;

import android.os.AsyncTask;
import android.util.Log;

import com.example.assistantbeekeeper.weatherwitget.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

public class DownloadData {

    private static final String Tag="DownloadData";

    public static URL createUrlAdress(){
        URL weatherUrl= NetworkUtils.buildUrlWeatheForFiveDay();
        Log.i(Tag, "Wheather utils"+ weatherUrl);
        return weatherUrl;
    }

   public static ArrayList<FiveDayWeatherDataClass> FetchDataFromWebside(){


        return null;
   }


   private static class DownloadWeatherDetails extends AsyncTask<URL, Void, String>{

        @Override
        protected void  onPreExecute(){
            super.onPreExecute();
        }


       //fetch data from server Weather for fiveDaysWeather
       @Override
       protected String doInBackground(URL... urls) {
            URL weatherurl=urls[0];
            String weatherDetailResult=null;

            try{
                weatherDetailResult=NetworkUtils.getResponseFromUrl(weatherurl);

            } catch (Exception e) {
                e.printStackTrace();
            }
           Log.i(Tag, " Weather details Result: "+ weatherDetailResult);

           return weatherDetailResult;
       }

       @Override
       protected void onPostExecute(String weatherDetailResult){

            ParseJson parseJson=new ParseJson(weatherDetailResult);


       }
   }





}
