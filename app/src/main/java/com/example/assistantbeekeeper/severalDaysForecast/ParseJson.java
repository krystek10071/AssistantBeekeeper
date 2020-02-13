package com.example.assistantbeekeeper.severalDaysForecast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJson {

    private String resultData;

      ParseJson(String string){
         this.resultData=string;
     }

     public ArrayList<FiveDayWeatherDataClass> parseJsonToObjectList(ArrayList<FiveDayWeatherDataClass> weatherDataObj){

          if(weatherDataObj!=null){
              weatherDataObj.clear();
          }

          if(resultData!=null){
            try {
                int lengthDailyForecast;
                JSONObject jsonObject=new JSONObject(resultData);
                JSONArray dailyForecastArray=jsonObject.getJSONArray("DailyForecasts");
                lengthDailyForecast=dailyForecastArray.length();

                for(int i=0; i<lengthDailyForecast; i++){
                    JSONObject resultObj=dailyForecastArray.getJSONObject(i);
                    long epochDate=resultObj.getLong("EpochDate");
                    int whetherIcon=resultObj.getJSONObject("Day").getInt("Icon");
                    String iconPhrase=resultObj.getJSONObject("Day").getString("IconPhrase");
                    double tDay=resultObj.getJSONObject("Temperature").getJSONObject("Maximum").getDouble("Value");
                    double tNight=resultObj.getJSONObject("Temperature").getJSONObject("Minimum").getDouble("Value");
                    double windSpeed=resultObj.getJSONObject("Day").getJSONObject("Wind").getJSONObject("Speed").getDouble("Value");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
          }


         return null;
     }
 }
