package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import android.app.Activity;
import android.content.Context;

import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProfitFormActivity;

public interface IFormPre {
    void writeToDatabse();

    void createObjectEntity(Context context);

    void validateFields(ProfitFormActivity activity, String inputName, String inputValue);
}
