package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;

public class FormPre {
    private AssistantDbAbstract databaseHandle;
    private StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();

    public void writeProfitToDatabase() {
    }

    public AssistantDbAbstract accessDatabase(Context context) {
        databaseHandle=statisticGeneralPre.createDatabase(context);
        return databaseHandle;
    }
}
