package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.os.Bundle;
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

public class StatisticGeneralFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(layout.general_statistics_fragment, container, false);
        Spinner customSpinnerStatistics = view.findViewById(id.spinner_statistic);

        ArrayList<CustomItems> customList=new ArrayList<>();

        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));
        customList.add(new CustomItems("enedue"));


        CustomAdapterSpinner customAdapter=new CustomAdapterSpinner(Objects.requireNonNull(getActivity()), layout.custom_spinner_layout, customList);
        //todo

        if(customSpinnerStatistics !=null){
            customSpinnerStatistics.setAdapter(customAdapter);
          // customSpinnerStatistics.setOnItemClickListener(this);
        }



        return view ;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        CustomItems items= (CustomItems) adapterView.getSelectedItem();
        Toast.makeText(getActivity(), items.getSpinnerText(), Toast.LENGTH_LONG).show();
    }
}
