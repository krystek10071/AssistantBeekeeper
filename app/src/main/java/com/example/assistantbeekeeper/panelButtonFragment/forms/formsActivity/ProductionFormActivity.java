package com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormCostPre;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormProductionPre;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre.DateParser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductionFormActivity extends AppCompatActivity {

    TextView placeNameText;
    TextInputLayout valueProduction;
    TextView dateProduction;
    FloatingActionButton floatingActionButton;
    Button buttonConfirmProduction;
    FormProductionPre formProductionPre=new FormProductionPre();
    //todo
    FormCostPre formPresenter= new FormCostPre();
    private AssistantDbAbstract databaseHandle;
    private Calendar calendar;
    Long timeInMillis;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_production);
        init();
        String namePlace= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");

        placeNameText.setText(namePlace);
        databaseHandle=formPresenter.accessDatabase(getBaseContext());


        //listeners
        floatingActionButton.setOnClickListener(view ->  setDateWithDataPicker(this));
        buttonConfirmProduction.setOnClickListener(view -> checkTheField());
    }

    private void init() {
        placeNameText=findViewById(R.id.placeName);
        valueProduction=findViewById(R.id.value_production);
        dateProduction=findViewById(R.id.date_production);
        floatingActionButton=findViewById(R.id.floatingButtonProduction);
        buttonConfirmProduction=findViewById(R.id.buttonConfirmProduction);
    }

    private void setDateWithDataPicker(Context context){


        DatePickerDialog datePickerDialog;
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);


        //set breeding day with DatePickerDialog
        datePickerDialog = new DatePickerDialog(context, (datePicker, mYear, mMonth, mDay) -> {
            DateParser dateParser=new DateParser();
            String dateBeforeConvertionFormat="EEE MMM dd HH:mm:ss zzz yyyy";
            String dateAfterConvertion="dd-MM-yyyy";
            String result;

            calendar.set(mYear, mMonth, mDay);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            timeInMillis = calendar.getTimeInMillis();

            Date date= calendar.getTime();
            result=dateParser.parseData(dateBeforeConvertionFormat, dateAfterConvertion, date.toString());
            Log.i("WYBOR DATY", result);
            dateProduction.setText(result);

            //new version
            timeInMillis=date.getTime();

            Log.i("WYBOR DATY", String.valueOf(timeInMillis));


        }, day, month, year);
        datePickerDialog.show();
    }

    private void checkTheField() {
        CostEntity costEntity;
        String inputValue= Objects.requireNonNull(valueProduction.getEditText()).getText().toString().trim();
        String inputDate = dateProduction.getText().toString().trim();
        String nameApiary= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        List<ApiaryEntity> list=databaseHandle.apiaryDAO().getIdApiaryByName(nameApiary);
        int valueHoneyProduction= Integer.parseInt(inputValue);

        if( inputValue.isEmpty() || inputDate.isEmpty()){
            Toast.makeText(this, "Musisz uzupełnić wszystkie pola", Toast.LENGTH_LONG).show();
        }else
        {

            formProductionPre.validateFields(this, inputValue);

            if (valueProduction.getError()==null){
                Toast.makeText(this, "Brak bledow", Toast.LENGTH_LONG).show();
               //todo

                formProductionPre.accessDatabase(this);
              //  formProductionPre.totalHoneyProduction(nameApiary);
                formProductionPre.updateFieldInDatabase(valueHoneyProduction, nameApiary);

                Toast.makeText(this, "Zapisano do bazy", Toast.LENGTH_LONG).show();
            }

        }
    }



}
