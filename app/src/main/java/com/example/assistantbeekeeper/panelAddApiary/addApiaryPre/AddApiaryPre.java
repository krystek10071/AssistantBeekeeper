package com.example.assistantbeekeeper.panelAddApiary.addApiaryPre;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormCostPre;

import java.util.Locale;

public class AddApiaryPre {
    private FormCostPre formCostPre=new FormCostPre();
    private static final String TAG="ADD_APIARY_PRE";

    public void writeToDatabase(ApiaryEntity apiaryEntity, Context context) {
        AssistantDbAbstract dbHandle = formCostPre.accessDatabase(context);
        dbHandle.apiaryDAO().insertAll(apiaryEntity);

        Log.i(TAG, "Add to apiary Entity");
        Toast.makeText(context, "Dodano do bazy danych", Toast.LENGTH_LONG).show();
    }
}
