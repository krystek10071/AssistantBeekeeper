package com.example.assistantbeekeeper.weatherwitget;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class WeatherWidget {


    private static final String TAG="WeatherWidget";
//build our URL Weather
    public static URL createUrlAddress(){
      URL weatherUrl=NetworkUtils.buildUrlWeatherForOneDay();
      Log.i(TAG, "Weather url: "+ weatherUrl);
      return weatherUrl;
    }
//download weather details
    public static ArrayList<CurrentWeatherDataClass> FetchDataWether(URL weatherUrl){
       new downloadWeatherDetails().execute(weatherUrl);
        return null;
    }

    private static class downloadWeatherDetails extends AsyncTask<URL, Void, String>{

       private ArrayList<CurrentWeatherDataClass> weatherDataClassArrayList=new ArrayList<>();

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



             //   Iterator itr=weatherDataClassArrayList.iterator();

             //   while (itr.hasNext()){
             //  CurrentWeatherDataClass wetherInIterator=(CurrentWeatherDataClass) itr.next();

             //  }

            }
            super.onPostExecute(weatherDetailsResult);


        }
    }

    /**
     *
     * @param weatherDetailsResult   this is JSON Text from accuweather data
     * @param weatherDataClassArrayList empty list
     * @return List with weather object
     */
    private static ArrayList<CurrentWeatherDataClass> parseJSON_Data
            (String weatherDetailsResult, ArrayList<CurrentWeatherDataClass> weatherDataClassArrayList){
        if(weatherDataClassArrayList!=null){
            weatherDataClassArrayList.clear();
        }

        if(weatherDetailsResult!=null){
            try {
                JSONObject jsonObject=new JSONObject(weatherDetailsResult);
                JSONArray dailyForecastArray=jsonObject.getJSONArray("DailyForecasts");
                JSONObject resultObj=dailyForecastArray.getJSONObject(0);

                        long epochDate=resultObj.getLong("EpochDate");
                        int whetherIcon=resultObj.getJSONObject("Day").getInt("Icon");
                        String iconPhrase=resultObj.getJSONObject("Day").getString("IconPhrase");
                        double temperature=resultObj.getJSONObject("Temperature").getJSONObject("Maximum").getDouble("Value");
                        double realFeelTemperature=resultObj.getJSONObject("RealFeelTemperature").getJSONObject("Maximum").getDouble("Value");
                        double windSpeed=resultObj.getJSONObject("Day").getJSONObject("Wind").getJSONObject("Speed").getDouble("Value");
                        int precipitationProbality=resultObj.getJSONObject("Day").getInt("PrecipitationProbability");

                        CurrentWeatherDataClass currentWeatherDataClass=new CurrentWeatherDataClass(epochDate, null, whetherIcon,
                                iconPhrase, temperature, realFeelTemperature, windSpeed, precipitationProbality, null);

                        if (weatherDataClassArrayList != null) {
                            weatherDataClassArrayList.add(currentWeatherDataClass);
                        }

                //JSONArray result=jsonObject.getJSONArray("DailyForecasts");
                //int lenghtResultJSON=result.length();
                // for(int i=0; i<lenghtResultJSON; i++){
                // CurrentWeatherDataClass currentWeatherDataClass=new CurrentWeatherDataClass();
                //   JSONObject resultObj=result.getJSONObject(i);
                // JSONObject epochDate=;
                //   JSONObject temperatureObj=resultObj.getJSONObject("Temperature");
                //   JSONObject wind=resultObj.getJSONObject("Day").getJSONObject("Wind").getJSONObject("Speed")
                //String date=resultObj.getString("Date");
                   // String minTemperature=temperatureObj.getJSONObject("Minimum").getString("Value");
                   // String maxTemperature=temperatureObj.getJSONObject("Maximum").getString("Value");
                  //  String windSpeed=wind.getString("Value");
                //   weatherDataClassArrayList.add(weatherDataClass);
              //  }

                Log.i(TAG, "Pogoda po parsowaniu JSON"+ weatherDataClassArrayList.get(0).getIconPhrase());

                return weatherDataClassArrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
            return null;

    }




    public static void setTextViewField(TextView currentLocation,TextView iconWeather, TextView currentTemperature
                                        , TextView describeWeatherIcon, TextView WindSpeed, TextView Pop
                                        , TextView SensibleTemperature){


    }



}
