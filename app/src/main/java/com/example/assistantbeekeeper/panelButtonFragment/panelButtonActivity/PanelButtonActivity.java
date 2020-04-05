package com.example.assistantbeekeeper.panelButtonFragment.panelButtonActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.CostFormActivity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProductionFormActivity;
import com.example.assistantbeekeeper.panelButtonFragment.forms.formsActivity.ProfitFormActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PanelButtonActivity extends Fragment {


    private static final String TAG="PANEL_BUTTON_ACTIVITY";
    private Button addCost;
    private Button addProfit;
    private Button addAmountOfProduction;
    private String nameApiary;

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
          Intent intent=new Intent(getActivity(), ProfitFormActivity.class);
          intent.putExtra("placeName", nameApiary);
          startActivity(intent);
        });

        addCost.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), CostFormActivity.class);
            intent.putExtra("placeName", nameApiary);
            startActivity(intent);
        });

        addAmountOfProduction.setOnClickListener(view1 -> {
            Intent intent=new Intent(getActivity(), ProductionFormActivity.class);
            intent.putExtra("placeName", nameApiary);
            startActivity(intent);
        });

        return view;
    }

    private void initComponents(View view){
        addCost=view.findViewById(R.id.add_cost_button);
        addProfit=view.findViewById(R.id.add_profit_button);
        addAmountOfProduction=view.findViewById(R.id.add_amount_production);
    }



    public void setNameApiary(String name_Apiary) {
        nameApiary=name_Apiary;
        Log.i(TAG, nameApiary);
        Toast.makeText(getContext(), name_Apiary, Toast.LENGTH_LONG).show();
    }
}
