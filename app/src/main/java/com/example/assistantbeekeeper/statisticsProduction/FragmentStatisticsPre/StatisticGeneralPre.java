package com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentActivity.CustomItems;
import com.example.assistantbeekeeper.statisticsProduction.FragmentActivity.StatisticGeneralFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.room.Room;

public class StatisticGeneralPre implements IStaticsGeneralPre {

    private static final String TAG="STATIC_GENERAL_PRE";

    @Override
    public AssistantDbAbstract createDatabase(Context context) {
        AssistantDbAbstract database = Room.databaseBuilder(Objects.requireNonNull(context), AssistantDbAbstract.class, "myDbDatabase.db").
                allowMainThreadQueries().build();

        ApiaryEntity apiaryEntity=new ApiaryEntity();
        CostEntity costEntity=new CostEntity();
        EarningsEntity earningsEntity=new EarningsEntity();

        return database;
    }

    @Override
    public void loadDataForPlaceName(Context context, StatisticGeneralFragment activity, String placeName) {
        Date date=new Date();
        List<EarningsEntity> listEarnings;
        List<CostEntity> listCost;
        List<ApiaryEntity> listApiary;

        AssistantDbAbstract databaseHandle;
        databaseHandle=createDatabase(context);

        listApiary=fetchListIdApiaryByName(placeName, databaseHandle);

        if(!listApiary.isEmpty()){
            listCost=databaseHandle.costDao().loadCurrentCostsInYear(1577833200000L, date.getTime(), listApiary.get(0).getId());
            listEarnings=databaseHandle.earningsDAO().loadCurrentCostsInYear(1577833200000L, date.getTime(), listApiary.get(0).getId());

            if(!listCost.isEmpty()){
                double totalValueCost;
                totalValueCost=countCosts(listCost);
                activity.setTotalCost(totalValueCost);
            }else
            {
                activity.setTotalCost(0);
            }

            if(!listEarnings.isEmpty()){
                double totalValueProfit;
                totalValueProfit=countEarnings(listEarnings);
                activity.setTotalProfit(totalValueProfit);
            }
            else{
                activity.setTotalProfit(0);
            }

            if(!listApiary.isEmpty()){
                double totalProduction;
                totalProduction=listApiary.get(0).getAmountOfHoney();
                activity.setTotalProduction(totalProduction);
            }
            else{
                activity.setTotalProfit(0);
            }

        }
        databaseHandle.close();
    }

    private double countEarnings(List<EarningsEntity> listEarnings) {
        double sum = 0;
        int size=listEarnings.size();
        for(int i=0; i<size; i++){
            sum+=listEarnings.get(i).getValue();
        }
        return sum;
    }

    private double countCosts(List<CostEntity> listCost) {
        double sum = 0;
        int size=listCost.size();
        for(int i=0; i<size; i++){
            sum+=listCost.get(i).getValue();
        }
        return sum;
    }

    public List<ApiaryEntity> fetchListIdApiaryByName(String placeName, AssistantDbAbstract dbHandle){
        List<ApiaryEntity> listApiary;
        listApiary= dbHandle.apiaryDAO().getIdApiaryByName(placeName);
        return listApiary;
    }


    public List<ApiaryEntity> loadTableApiaryEntity(List<ApiaryEntity> apiaryListItem, AssistantDbAbstract database) {
        apiaryListItem=database.apiaryDAO().getAll();
        if(apiaryListItem.isEmpty()){
            Log.i(TAG, "Apiary Entity is Empty");
        }
        return apiaryListItem;
    }

    public ArrayList<CustomItems> loadDataToCustomList(List<ApiaryEntity> apiaryListItem) {
        ArrayList <CustomItems> customItems=new ArrayList<>();
        int lenght=apiaryListItem.size();

        for(int i=0; i<lenght; i++){
            customItems.add(new CustomItems(apiaryListItem.get(i).getName()));
        }
        return customItems;
    }
}
