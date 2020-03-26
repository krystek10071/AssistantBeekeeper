package com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formPre.FormPre;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CostFormActivity extends AppCompatActivity {

    TextInputLayout textInputName;
    TextInputLayout textInputValue;
    TextInputLayout textInputDate;
    Button buttonAkcept;
    FloatingActionButton floatingActionButton;
    private Calendar calendar;
    Long timeInMillis;
    FormPre formPre;
    TextView placeName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cost);
        init();

        String namePlace= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        init();
        placeName.setText(namePlace);

        //listeners
        floatingActionButton.setOnClickListener(view ->  setDateWithDataPicker(this));
        buttonAkcept.setOnClickListener(view -> checkTheField());

    }


    private void checkTheField() {
        String inputName= Objects.requireNonNull(textInputName.getEditText()).getText().toString().trim();
        String inputValue= Objects.requireNonNull(textInputValue.getEditText()).getText().toString().trim();
        String inputDate= Objects.requireNonNull(textInputDate.getEditText()).getText().toString().trim();
        String apiary_id_entity;

        if(inputName.isEmpty() || inputValue.isEmpty() || inputDate.isEmpty()){
            Toast.makeText(this, "Musisz uzupełnić wszystkie pola", Toast.LENGTH_LONG).show();
        }else
        {

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
