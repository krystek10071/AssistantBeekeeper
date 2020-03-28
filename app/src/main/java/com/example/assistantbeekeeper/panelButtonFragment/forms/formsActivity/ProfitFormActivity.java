package com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormPre;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfitFormActivity extends AppCompatActivity {
    TextInputLayout textInputName;
    TextInputLayout textInputValue;
    TextInputLayout textInputDate;
    TextView placeName;
    Button buttonAkcept;
    FloatingActionButton floatingActionButton;
    private Calendar calendar;
    Long timeInMillis;
    FormPre formPresenter=new FormPre();
    private AssistantDbAbstract databaseHandle;
    String namePlace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_profit);
        init();

        namePlace= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        placeName.setText(namePlace);
        databaseHandle=formPresenter.accessDatabase(getBaseContext());


        //listeners
        floatingActionButton.setOnClickListener(view ->  setDateWithDataPicker(this));
        buttonAkcept.setOnClickListener(view -> checkTheField());
    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void checkTheField() {
        EarningsEntity earningsEntity;
        String inputName= Objects.requireNonNull(textInputName.getEditText()).getText().toString().trim();
        String inputValue= Objects.requireNonNull(textInputValue.getEditText()).getText().toString().trim();
        String inputDate= Objects.requireNonNull(textInputDate.getEditText()).getText().toString().trim();
        String nameApiary= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        List<ApiaryEntity> list=databaseHandle.apiaryDAO().getIdApiaryByName(nameApiary);

        if(inputName.isEmpty() || inputValue.isEmpty() || inputDate.isEmpty()) {
            Toast.makeText(this, "Musisz uzupełnić wszystkie pola", Toast.LENGTH_LONG).show();
        }
        else{

            formPresenter.validateFields(this, inputName, inputValue);

            if(textInputName.getError()==null && textInputValue.getError()==null){
                Toast.makeText(this, "Brak bledow", Toast.LENGTH_LONG).show();

               earningsEntity=formPresenter.createObjectEntity(inputName, inputValue, inputDate, list);
               formPresenter.writeToDatabse(earningsEntity);
               Toast.makeText(this, "Zapisano do bazy", Toast.LENGTH_LONG).show();
            }

        }


    }

    public void disableErrorTextInputName(){
        textInputName.setError(null);
    }


    public void disableErrorTextInputValue(){
        textInputValue.setError(null);
    }

    public void setErrorTextInputName(String message){
        textInputName.setError(message);
    }

    public void setErrorTextInputValue(String message){
        textInputValue.setError(message);
    }

    public void init(){
        textInputName=findViewById(R.id.name_profit);
        textInputValue=findViewById(R.id.value_profit);
        textInputDate=findViewById(R.id.date_profit);
        buttonAkcept=findViewById(R.id.buttonConfirmProfit);
        floatingActionButton=findViewById(R.id.floatingButtonProfit);
        placeName=findViewById(R.id.placeName);
    }

    private void setDateWithDataPicker(Context context){
        DatePickerDialog datePickerDialog;
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);


        //set breeding day with DatePickerDialog
        datePickerDialog = new DatePickerDialog(context, (datePicker, mYear, mMonth, mDay) -> {
            calendar.set(mYear, mMonth, mDay);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            timeInMillis = calendar.getTimeInMillis();
            Log.i("WYBOR DATY", Long.toString(timeInMillis));
            String output=String.format("%tQ", calendar.getTimeInMillis());                     //set output string with time in millis
        }, day, month, year);
        datePickerDialog.show();
    }
}
