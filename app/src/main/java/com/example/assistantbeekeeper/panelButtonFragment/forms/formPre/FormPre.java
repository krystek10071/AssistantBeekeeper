package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import android.content.Context;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProfitFormActivity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;

public class FormPre implements IFormPre {
    private AssistantDbAbstract databaseHandle;
    private StatisticGeneralPre statisticGeneralPre=new StatisticGeneralPre();

    public AssistantDbAbstract accessDatabase(Context context) {
        databaseHandle=statisticGeneralPre.createDatabase(context);
        return databaseHandle;
    }

    @Override
    public void writeToDatabse() {

    }

    @Override
    public void createObjectEntity(Context context) {

    }


    @Override
    public void validateFields(ProfitFormActivity activity, String inputName, String inputValue) {
        ValidatorForms validator=new ValidatorForms();
        String error1, error2;

        error1=validator.validInputName(inputName);
        error2=validator.validInputValue(inputValue);

        if(!error1.equals(inputName)){
            activity.setErrorTextInputName(error1);
        }
        else {
           activity.disableErrorTextInputName(null);
        }

        if(!error2.equals(inputValue)){
            activity.setErrorTextInputValue(error2);
        }else
        {
            activity.disableErrorTextInputValue(null);
        }


    }
}
