package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.models.OperationsData;

import java.util.ArrayList;
import java.util.List;

public class ListOfOperationsPre {
    public void loadDataToRecycleView(Context context) {
        List<EarningsEntity> earningsEntities;
        List<CostEntity> costEntities;

        StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();
        AssistantDbAbstract databaseHandle=statisticGeneralPre.createDatabase(context);

        earningsEntities=databaseHandle.earningsDAO().getAll();
        costEntities=databaseHandle.costDao().getAll();

         prepareListOfOperations(earningsEntities, costEntities);
    }



    private void prepareListOfOperations(List<EarningsEntity> earningsEntities, List<CostEntity> costEntities) {
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        ArrayList<OperationsData> listEarnings=new ArrayList<>();
        ArrayList<OperationsData> listCosts=new ArrayList<>();

        listEarnings=convertEarnigsToOperationData(earningsEntities);
        listCosts=convertCostsToOperationData(costEntities);

        listArticle.addAll(listEarnings);
        listArticle.addAll(listCosts);


    }

    private ArrayList<OperationsData> convertEarnigsToOperationData(List<EarningsEntity> earningsEntities){
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        int lengthEarnings=earningsEntities.size();

        for(int i=0; i<lengthEarnings; i++){
            OperationsData obj=new OperationsData();
            obj.setDate(String.valueOf(earningsEntities.get(i).getData()));
            obj.setValue(String.valueOf(earningsEntities.get(i).getValue()));
            obj.setDescription(earningsEntities.get(i).getName());
            obj.setTimeInMillis(earningsEntities.get(i).getData());
            listArticle.add(obj);
        }
        return listArticle;
    }

    private ArrayList<OperationsData> convertCostsToOperationData(List<CostEntity> costEntities){
        ArrayList<OperationsData> listArticle=new ArrayList<>();
        int lengthCosts=costEntities.size();

        for(int i=0; i<lengthCosts; i++){
            OperationsData obj=new OperationsData();
            obj.setDate(String.valueOf(costEntities.get(i).getData()));
            obj.setValue(String.valueOf(costEntities.get(i).getValue()));
            obj.setDescription(costEntities.get(i).getName());
            obj.setTimeInMillis(costEntities.get(i).getData());
            listArticle.add(obj);
        }
        return listArticle;
    }
}
