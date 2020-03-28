package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.CostFormActivity;

import java.util.List;

interface IFormCost {
    void writeToDatabse(CostEntity costEntity);

    CostEntity createObjectEntity(String name, String value, String date, List<ApiaryEntity> list);

    void validateFields(CostFormActivity activity, String inputName, String inputValue);
}
