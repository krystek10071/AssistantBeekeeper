package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProductionFormActivity;

import java.util.List;

public interface IFormProductionPre {

    void validateFields(ProductionFormActivity productionFormActivity, String inputValue);

    void updateFieldInDatabase(int sumHoney, String nameApiary);


    int honeyProductionInApiary(String nameApiary);
}
