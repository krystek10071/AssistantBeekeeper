package com.example.assistantbeekeeper.panelButtonFragment.panelButtonActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.example.assistantbeekeeper.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EntryFormActivity extends AppCompatActivity {
    TextInputLayout textInputLayout;
    TextInputLayout textInputLayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cost_profit);
        init();
        //String string= Objects.requireNonNull(textInputLayout.getEditText()).getText().toString().trim();

    }

    public void init(){
        textInputLayout=findViewById(R.id.textInput1);
        textInputLayout2=findViewById(R.id.textInput2);
    }
}
