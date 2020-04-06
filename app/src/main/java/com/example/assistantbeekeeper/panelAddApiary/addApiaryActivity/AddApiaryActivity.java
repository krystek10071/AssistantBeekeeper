package com.example.assistantbeekeeper.panelAddApiary.addApiaryActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.panelAddApiary.addApiaryPre.AddApiaryPre;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddApiaryActivity extends AppCompatActivity {

    TextInputLayout apiaryName, honey_production;
    Button confirmButton;
    AddApiaryPre addApiaryPre=new AddApiaryPre();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_add_apiary);
        init();

        confirmButton.setOnClickListener(view -> prepareObject());

    }

    private void prepareObject() {
        ApiaryEntity apiaryEntity=new ApiaryEntity();
        apiaryEntity.setName(Objects.requireNonNull(apiaryName.getEditText()).getText().toString());
        apiaryEntity.setAmountOfHoney(Integer.parseInt(Objects.requireNonNull(honey_production.getEditText()).getText().toString()));
        addApiaryPre.writeToDatabase(apiaryEntity, this);

    }

    void init(){
        apiaryName=findViewById(R.id.name_apiary);
        honey_production=findViewById(R.id.value_production);
        confirmButton=findViewById(R.id.buttonConfirmApiary);
    }
}
