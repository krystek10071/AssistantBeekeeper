package com.example.assistantbeekeeper.panelButtonFragment.panelButtonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.assistantbeekeeper.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PanelButtonActivity extends Fragment {


    private Button addCost;
    private Button addProfit;
    private Button addAmountOfProduction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.panel_button, container,false);
        initComponents(view);

        addProfit.setOnClickListener(view1 -> {
          Intent intent=new Intent(getActivity(), EntryFormActivity.class);
          startActivity(intent);
        });

        return view;
    }

    private void initComponents(View view){
        addCost=view.findViewById(R.id.add_cost_button);
        addProfit=view.findViewById(R.id.add_profit_button);
        addAmountOfProduction=view.findViewById(R.id.add_amount_production);


    }

    private void createFormView(){

    }



}
