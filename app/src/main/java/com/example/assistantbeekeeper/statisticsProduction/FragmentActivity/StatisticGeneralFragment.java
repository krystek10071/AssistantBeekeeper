package com.example.assistantbeekeeper.statisticsProduction.FragmentActivity;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.statisticsProduction.FragmentStatisticsPre.StatisticGeneralPre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.assistantbeekeeper.R.*;

public class StatisticGeneralFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private ArrayList<CustomItems> customList=new ArrayList<>();
    private TextView apiaryName;
    private static final String TAG="STATISTIC_GENERAL_STATIC";
    private OverviewFragmentActivityListener listener;

    List<ApiaryEntity> apiaryListItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatisticGeneralPre statisticGeneralPre = new StatisticGeneralPre();

        //Create mydatabase
        statisticGeneralPre.createDatabase(getContext());

    }


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        listener=(OverviewFragmentActivityListener) activity;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        customList.add(new CustomItems("Bytom"));
        customList.add(new CustomItems("Miejscowosc2"));
        customList.add(new CustomItems("Wrotkowo"));
        customList.add(new CustomItems("Ksiezypole"));

        View view=inflater.inflate(layout.general_statistics_fragment, container, false);
        initComponent(view);

         Spinner customSpinnerStatistics = view.findViewById(id.spinner_statistic);
         customSpinnerStatistics.setOnItemSelectedListener(this);
        CustomAdapterSpinner customAdapter=new CustomAdapterSpinner(getContext(), customList);
        customSpinnerStatistics.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();

        //todo
        listener.sendIdApiaryToPanelButton(14L);

        return view ;
    }



    //interface for communication between fragments
    public interface OverviewFragmentActivityListener{

        //method for communication between Static General Fragment and Panel button
        void sendIdApiaryToPanelButton(Long id_apiary);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("POSITION", String.valueOf(adapterView.getAdapter().getItem(i)));

        String placeName=customList.get(i).getSpinnerText();
        setApiaryName(placeName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


    private void setApiaryName(String name){
        apiaryName.setText(name);
    }



    private void initComponent(View view){
        apiaryName=view.findViewById(id.apiaryName);
    }
}
