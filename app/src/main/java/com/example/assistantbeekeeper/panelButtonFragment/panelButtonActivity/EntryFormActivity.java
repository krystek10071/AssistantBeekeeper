package com.example.assistantbeekeeper.panelButtonFragment.panelButtonActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.assistantbeekeeper.BreedingFunctions;
import com.example.assistantbeekeeper.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EntryFormActivity extends AppCompatActivity {
    TextInputLayout textInputName;
    TextInputLayout textInputValue;
    EditText textInputDate;
    Button buttonAkcept;
    FloatingActionButton floatingActionButton;
    private Calendar calendar;
    Long timeInMillis;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cost_profit);
        init();

        floatingActionButton.setOnClickListener(view -> { setDateWithDataPicker(this);});
    }

    public void init(){
        textInputName=findViewById(R.id.textInput1);
        textInputValue=findViewById(R.id.textInput2);
        textInputDate=findViewById(R.id.textInput3);
        buttonAkcept=findViewById(R.id.buttonAkcept);
        floatingActionButton=findViewById(R.id.floatingActionButton1);
    }

    private void setDateWithDataPicker(Context context){
        DatePickerDialog datePickerDialog;
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // final Long[] timeinmillis = new Long[1];
        //timeinmillis[0]=0L;
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
