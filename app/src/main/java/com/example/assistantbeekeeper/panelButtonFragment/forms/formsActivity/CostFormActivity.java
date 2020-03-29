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
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.DateFormater;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormCostPre;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormProfitPre;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre.DateParser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CostFormActivity extends AppCompatActivity {

    TextInputLayout textInputName;
    TextInputLayout textInputValue;
    TextView textInputDate;
    Button buttonAkcept;
    FloatingActionButton floatingActionButton;
    private Calendar calendar;
    Long timeInMillis;
    FormProfitPre formPre;
    TextView placeName;
    private AssistantDbAbstract databaseHandle;
    FormCostPre formPresenter=new FormCostPre();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cost);
        init();

        String namePlace= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        init();
        placeName.setText(namePlace);
        databaseHandle=formPresenter.accessDatabase(getBaseContext());

        //listeners
        floatingActionButton.setOnClickListener(view ->  setDateWithDataPicker(this));
        buttonAkcept.setOnClickListener(view -> checkTheField());

    }


    private void checkTheField() {
        CostEntity costEntity;
        String inputName= Objects.requireNonNull(textInputName.getEditText()).getText().toString().trim();
        String inputValue= Objects.requireNonNull(textInputValue.getEditText()).getText().toString().trim();
        String inputDate= (String) Objects.requireNonNull(textInputDate.getText());
        String nameApiary= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        List<ApiaryEntity> list=databaseHandle.apiaryDAO().getIdApiaryByName(nameApiary);

        if(inputName.isEmpty() || inputValue.isEmpty() || inputDate.isEmpty()){
            Toast.makeText(this, "Musisz uzupełnić wszystkie pola", Toast.LENGTH_LONG).show();
        }else
        {

            formPresenter.validateFields(this, inputName, inputValue);

            if(textInputName.getError()==null && textInputValue.getError()==null){
                Toast.makeText(this, "Brak bledow", Toast.LENGTH_LONG).show();

                costEntity=formPresenter.createObjectEntity(inputName, inputValue, inputDate, list);
                formPresenter.writeToDatabse(costEntity);
                Toast.makeText(this, "Zapisano do bazy", Toast.LENGTH_LONG).show();
            }

        }
    }


    public void init(){
        textInputName=findViewById(R.id.textInput1);
        textInputValue=findViewById(R.id.textInput2);
        textInputDate=findViewById(R.id.textInput3);
        buttonAkcept=findViewById(R.id.buttonConfirmProfit);
        floatingActionButton=findViewById(R.id.floatingActionButton1);
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
            DateParser dateParser=new DateParser();
            String dateBeforeConvertionFormat="EEE MMM DD HH:mm:ss zzz yyyy";
            String dateAfterConvertion="dd-MM-yyyy";
            String result;

            calendar.set(mYear, mMonth, mDay);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            timeInMillis = calendar.getTimeInMillis();
            Log.i("WYBOR DATY", Long.toString(timeInMillis));
            String output = String.format("%tQ", calendar.getTimeInMillis());                     // set output string with time in millis

            Date date= calendar.getTime();
            result=dateParser.parseData(dateBeforeConvertionFormat, dateAfterConvertion, date.toString());
            Log.i("WYBOR DATY", result);
            textInputDate.setText(result);


        }, day, month, year);
        datePickerDialog.show();
    }

    public void setErrorTextInputName(String error1) {
        textInputName.setError(error1);
    }

    public void disableErrorTextInputName() {
        textInputName.setError(null);
    }

    public void setErrorTextInputValue(String error2) {
        textInputValue.setError(error2);
    }

    public void disableErrorTextInputValue() {
        textInputValue.setError(null);
    }
}
