package com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;

import java.util.List;

public interface IStaticsGeneralPre {
     AssistantDbAbstract createDatabase(Context context);

     void loadDataForPlaceName(Context context, String placeName);
     List<ApiaryEntity> fetchListIdApiaryByName(String placeName, AssistantDbAbstract dbHandle);
}
