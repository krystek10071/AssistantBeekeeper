package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapterSpinner extends ArrayAdapter {
    public CustomAdapterSpinner(@NonNull Context context, int resource, ArrayList<CustomItems> customList) {
        super(context, resource, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    public View customView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_layout, parent, false);
        }

        CustomItems items= (CustomItems) getItem(position);
        TextView spinnerTextView= convertView.findViewById(R.id.textViewSpinner);
        RadioButton radioButton=convertView.findViewById(R.id.radioButtonSpinner);

        if(items!=null){
            spinnerTextView.setText(items.getSpinnerText());
        }
        return convertView;
    }



}
