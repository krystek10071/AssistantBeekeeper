package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProfitFormActivity;

import java.util.List;

public interface IFormPre {
    void writeToDatabse(EarningsEntity earningsEntity);

    EarningsEntity createObjectEntity(String name, String value, String date, List<ApiaryEntity> list);

    void validateFields(ProfitFormActivity activity, String inputName, String inputValue);
}
