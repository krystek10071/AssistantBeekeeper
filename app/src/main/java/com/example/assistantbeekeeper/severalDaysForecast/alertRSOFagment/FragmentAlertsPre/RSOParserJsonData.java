package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;

import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.DataModel.AlertsWeatherData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RSOParserJsonData {

    private String jsonString;

    public RSOParserJsonData(String jsonString) {
        this.jsonString = jsonString;
    }

   List<AlertsWeatherData> ParseJsonToObject(){

       ArrayList<AlertsWeatherData> alertsWeatherDataList=new ArrayList<>();

       if(jsonString!=null){
           try {
               int lengthNewses;
               JSONObject jsonObject=new JSONObject(jsonString);
               JSONArray jsonNewsesArray=jsonObject.getJSONArray("newses");
               lengthNewses=jsonNewsesArray.length();

               for (int i =0; i< lengthNewses; i++){
                   JSONObject jsonObjectNews=jsonNewsesArray.getJSONObject(i);
                   String title=jsonObjectNews.getString("title");
                   String descriptionEvent=jsonObjectNews.getString("content");
                   String validFrom=jsonObjectNews.getString("valid_from");
                   String validTo=jsonObjectNews.getString("valid_to");
                   String provincy=jsonObject.getJSONObject("provinces").getString("name");

                   AlertsWeatherData alertWeatherObj=new AlertsWeatherData(title, provincy, validFrom, validTo, descriptionEvent);
                   alertsWeatherDataList.add(alertWeatherObj);
                   return alertsWeatherDataList;
               }
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }

        return null;
   }

}
