package com.example.assistantbeekeeper.severalDaysForecast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.assistantbeekeeper.weatherwitget.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

 class DownloadData {

    private static final String Tag="DownloadData";

     static URL createUrlAdress(){
        URL weatherUrl= NetworkUtils.buildUrlWeatheForFiveDay();
        Log.i(Tag, "Wheather utils"+ weatherUrl);
        return weatherUrl;
    }


     static void FetchDataFromWebside(URL url, Context context){
        new DownloadWeatherDetails(context).execute(url);
   }


   private static class DownloadWeatherDetails extends AsyncTask<URL, Void, String>{

         @SuppressLint("StaticFieldLeak")
         Context context;

         DownloadWeatherDetails (Context context){
             this.context=context;
         }

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

            FiveDaysForecastActivity fiveDaysForecastActivity;
            ArrayList<FiveDayWeatherDataClass> fiveDayWeatherData;
            ParseJson parseJson=new ParseJson(weatherDetailResult);
            fiveDayWeatherData=parseJson.parseJsonToObjectList();


            //send data to FiveDaysForecastActivity





       }
   }





}
