package com.example.assistantbeekeeper.weatherwitget;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class WeatherWidget {

    private static final String TAG="WeatherWidget";

//build our URL Weather


    public static URL createUrlAddress(){
      URL weatherUrl=NetworkUtils.buildUrlWeather();
      Log.i(TAG, "Weather url: "+ weatherUrl);
      return weatherUrl;
    }

    public static void FetchDataWether(URL weatherUrl){
       new downloadWeatherDetails().execute(weatherUrl);
    }



    private static class downloadWeatherDetails extends AsyncTask<URL, Void, String>{

       private ArrayList<WeatherDataClass> weatherDataClassArrayList=new ArrayList<>();

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
           URL weatherUrl=urls[0];
           String weatherDetailsResult=null;

           try {
               weatherDetailsResult=NetworkUtils.getResponseFromUrl(weatherUrl);
           } catch (IOException e) {
               e.printStackTrace();
           }

           Log.i(TAG, " Weather details Result: "+ weatherDetailsResult);
            return weatherDetailsResult;
        }

        @Override
        protected void onPostExecute(String weatherDetailsResult) {

            if(weatherDetailsResult!=null && !weatherDetailsResult.equals("")){
                weatherDataClassArrayList=parseJSON_Data(weatherDetailsResult, weatherDataClassArrayList);


            }
            super.onPostExecute(weatherDetailsResult);


        }
    }


    private static ArrayList<WeatherDataClass> parseJSON_Data
            (String weatherDetailsResult, ArrayList<WeatherDataClass> weatherDataClassArrayList){
        if(weatherDataClassArrayList!=null){
            weatherDataClassArrayList.clear();
        }

        if(weatherDetailsResult!=null){
            try {
                JSONObject jsonObject=new JSONObject(weatherDetailsResult);
                JSONArray result=jsonObject.getJSONArray("DailyForecasts");
                int lenghtResultJSON=result.length();
                for(int i=0; i<lenghtResultJSON; i++){
                    WeatherDataClass weatherDataClass=new WeatherDataClass();

                    JSONObject resultObj=result.getJSONObject(i);
                    String date=resultObj.getString("Date");
                    Log.i("DATA PO KONWERSJI", date);


                }


                return weatherDataClassArrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
            return null;

    }


}
