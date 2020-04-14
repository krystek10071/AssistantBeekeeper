package com.example.assistantbeekeeper.weatherwitget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.assistantbeekeeper.Breeding.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class LocationKey {
    private static final String TAG="LOCATION_KEY";

    //download weather details
    public static String FetchLocationKeyJSON(MainActivity activity, URL weatherUrl){
        new DownloadLocationKey(activity).execute(weatherUrl);
        return null;
    }

    private static class DownloadLocationKey extends AsyncTask<URL, Void, String> {

        private ArrayList<CurrentWeatherDataClass> weatherDataClassArrayList=new ArrayList<>();
        private MainActivity mainActivity;

        private DownloadLocationKey(MainActivity activity) {
            this.mainActivity=activity;
        }


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
            try {
                JSONArray jsonArray=new JSONArray(weatherDetailsResult);
                JSONObject jsonObject=jsonArray.getJSONObject(0);
                int keyLocation= jsonObject.getInt("Key");
                Log.i(TAG, String.valueOf(keyLocation));

                mainActivity.createCurrentWeatherForecast(keyLocation);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
