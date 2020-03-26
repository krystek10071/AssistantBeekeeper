package com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre;

import android.content.Context;
import android.util.Log;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentActivity.CustomItems;

import java.util.ArrayList;
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
