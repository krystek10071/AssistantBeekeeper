package com.example.assistantbeekeeper.severalDaysForecast;

import java.util.ArrayList;

public class ParseJson {

    private String resultData;
    private ArrayList<FiveDayWeatherDataClass> fiveDaysWeatherDataObj;

      ParseJson(String string){
         this.resultData=string;
     }

     public ArrayList<FiveDayWeatherDataClass> parseJsonToObjectList(){

         return null;
     }
 }
