package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapterSpinner extends BaseAdapter {
    private ArrayList<CustomItems> customItems;
    private LayoutInflater inflater;

    public CustomAdapterSpinner(Context context, ArrayList<CustomItems> customItems) {
        this.customItems = customItems;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {

        return customItems.size();
    }

    @Override
    public Object getItem(int i) {
      return   customItems.get(i);
    }

    @Override
    public long getItemId(int i) {

        return 0;
    }


    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.custom_spinner_layout, null);
        TextView textView=view.findViewById(R.id.textViewSpinner);
        textView.setText(customItems.get(i).getSpinnerText());
        return view;
    }
}
