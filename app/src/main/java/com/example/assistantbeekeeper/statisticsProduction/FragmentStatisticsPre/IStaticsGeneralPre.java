package com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;

public interface IStaticsGeneralPre {
     AssistantDbAbstract createDatabase(Context context);
}
