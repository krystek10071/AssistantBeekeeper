package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProductionFormActivity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;

import java.util.List;

public class FormProductionPre implements IFormProductionPre {

    private AssistantDbAbstract databaseHandle;
    private StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();

    public AssistantDbAbstract accessDatabase(Context context) {
        databaseHandle=statisticGeneralPre.createDatabase(context);
        return databaseHandle;
    }


    public void validateFields(ProductionFormActivity productionFormActivity, String inputValue) {
    }

    @Override
    public void updateFieldInDatabase(int sumHoney, String nameApiary) {
        int honeyProduction;
        List<ApiaryEntity> listSumApiary=databaseHandle.apiaryDAO().getIdApiaryByName(nameApiary);

        if(nameApiary!=null){
         honeyProduction=honeyProductionInApiary(nameApiary);
         honeyProduction+=sumHoney;
         databaseHandle.apiaryDAO().changeAmountOfHoney(listSumApiary.get(0).getId(), honeyProduction);
        }
    }

    @Override
    public int honeyProductionInApiary(String nameApiary) {

        List<ApiaryEntity> listSumApiary;
        int totalSumInApiary;

        if(nameApiary != null){
            try {
                listSumApiary=databaseHandle.apiaryDAO().getIdApiaryByName(nameApiary);
                totalSumInApiary=listSumApiary.get(0).getAmountOfHoney();
                return totalSumInApiary;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
