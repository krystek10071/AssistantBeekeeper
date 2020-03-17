package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.assistantbeekeeper.R;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.assistantbeekeeper.R.*;

public class StatisticGeneralFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ArrayList<CustomItems> customList=new ArrayList<>();
    private Spinner customSpinnerStatistics;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));

        View view=inflater.inflate(layout.general_statistics_fragment, container, false);
         Spinner customSpinnerStatistics = view.findViewById(id.spinner_statistic);
         customSpinnerStatistics.setOnItemSelectedListener(this);

        CustomAdapterSpinner customAdapter=new CustomAdapterSpinner(getContext(), customList);
        //todo
        customSpinnerStatistics.setAdapter(customAdapter);
        customSpinnerStatistics.setVisibility(View.VISIBLE);

       // customSpinnerStatistics.setOnItemClickListener((AdapterView.OnItemClickListener) this.getView());

        return view ;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Log.i()
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
