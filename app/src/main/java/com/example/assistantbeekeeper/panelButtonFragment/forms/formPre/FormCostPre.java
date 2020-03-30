package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.CostFormActivity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;

import java.util.List;

public class FormCostPre implements IFormCost {

    private AssistantDbAbstract databaseHandle;
    private StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();

    public AssistantDbAbstract accessDatabase(Context context) {
        databaseHandle=statisticGeneralPre.createDatabase(context);
        return databaseHandle;
    }


    @Override
    public void writeToDatabse(CostEntity costEntity) {
        databaseHandle.costDao().insertAll(costEntity);
    }

    @Override
    public CostEntity createObjectEntity(String name, String value, Long date, List<ApiaryEntity> list) {
        CostEntity objCost=new CostEntity();
        objCost.setName(name);
        objCost.setValue(Double.valueOf(value));
        objCost.setData(date);
        objCost.setIdApiaryEntity(list.get(0).getId());

        return  objCost;
    }

    @Override
    public void validateFields(CostFormActivity activity, String inputName, String inputValue) {
        ValidatorForms validator=new ValidatorForms();
        String error1, error2;

        error1=validator.validInputName(inputName);
        error2=validator.validInputValue(inputValue);

        if(!error1.equals(inputName)){
            activity.setErrorTextInputName(error1);
        }
        else {
            activity.disableErrorTextInputName();
        }

        if(!error2.equals(inputValue)){
            activity.setErrorTextInputValue(error2);
        }else
        {
            activity.disableErrorTextInputValue();
        }
    }
}
