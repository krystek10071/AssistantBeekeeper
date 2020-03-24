package com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;

import java.util.Objects;

import androidx.room.Room;

public class StatisticGeneralPre implements IStaticsGeneralPre {

    @Override
    public void createDatabase(Context context) {
        AssistantDbAbstract database = Room.databaseBuilder(Objects.requireNonNull(context), AssistantDbAbstract.class, "myDbDatabase.db").
                allowMainThreadQueries().build();

        ApiaryEntity apiaryEntity=new ApiaryEntity();
        CostEntity costEntity=new CostEntity();
        EarningsEntity earningsEntity=new EarningsEntity();
    }



    public void loadTableApiaryEntity() {

    }
}
