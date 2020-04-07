package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticPre;

import android.app.Activity;
import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre.DateParser;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticActivity.ListOfOperationsActivity;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.models.OperationsData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ListOfOperationsPre {

    public ArrayList<OperationsData> loadDataToRecycleView(Context context, ListOfOperationsActivity activity, String placeName) {
        ArrayList<OperationsData> listArticle;
        List<EarningsEntity> earningsEntities;
        List<CostEntity> costEntities;
        List<ApiaryEntity> apiaryEntities;

        StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();
        AssistantDbAbstract databaseHandle=statisticGeneralPre.createDatabase(context);

        apiaryEntities=databaseHandle.apiaryDAO().getIdApiaryByName(placeName);

        earningsEntities=databaseHandle.earningsDAO().loadProfitByIdApiary(apiaryEntities.get(0).getId());
        costEntities=databaseHandle.costDao().loadCostsByIdApiary(apiaryEntities.get(0).getId());

         listArticle=prepareListOfOperations(earningsEntities, costEntities);

         if(listArticle.isEmpty()){activity.displayMessage("Brak elementów do wyświetlenia");}

         databaseHandle.close();
         return listArticle;
    }



    private ArrayList<OperationsData> prepareListOfOperations(List<EarningsEntity> earningsEntities, List<CostEntity> costEntities) {
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        ArrayList<OperationsData> listEarnings;
        ArrayList<OperationsData> listCosts;

        listEarnings=convertEarnigsToOperationData(earningsEntities);
        listCosts=convertCostsToOperationData(costEntities);

        listArticle.addAll(listEarnings);
        listArticle.addAll(listCosts);

        Collections.sort(listArticle);

        return listArticle;
    }

    private ArrayList<OperationsData> convertEarnigsToOperationData(List<EarningsEntity> earningsEntities){
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        int lengthEarnings=earningsEntities.size();

        for(int i=0; i<lengthEarnings; i++){
            OperationsData obj=new OperationsData();

            String dateInString=convertTimeInMillisToDate(earningsEntities.get(i).getData());
            String value="+" + earningsEntities.get(i).getValue().toString();

            obj.setDate(dateInString);
            obj.setValue(value);
            obj.setDescription(earningsEntities.get(i).getName());
            obj.setTimeInMillis(earningsEntities.get(i).getData());
            obj.setProfit(true);
            obj.setCosts(false);
            listArticle.add(obj);
        }
        return listArticle;
    }

    private String convertTimeInMillisToDate(Long timeInMillis) {
       Date date=new Date();
       DateParser dateParser=new DateParser();
       String dateBeforeConvertionFormat="EEE MMM dd HH:mm:ss zzz yyyy";
       String dateAfterConvertion="dd-MM-yyyy";
       String outputDate;

       date.setTime(timeInMillis);
       outputDate=dateParser.parseData(dateBeforeConvertionFormat, dateAfterConvertion, date.toString());

        return outputDate;
    }

    private ArrayList<OperationsData> convertCostsToOperationData(List<CostEntity> costEntities){
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        int lengthCosts=costEntities.size();

        for(int i=0; i<lengthCosts; i++){
            OperationsData obj=new OperationsData();

            String dateInString=convertTimeInMillisToDate(costEntities.get(i).getData());
            String value="-" + costEntities.get(i).getValue().toString();

            obj.setDate(dateInString);
            obj.setValue(value);
            obj.setDescription(costEntities.get(i).getName());
            obj.setTimeInMillis(costEntities.get(i).getData());
            obj.setProfit(false);
            obj.setCosts(true);
            listArticle.add(obj);
        }
        return listArticle;
    }
}
