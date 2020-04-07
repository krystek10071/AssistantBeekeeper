package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticPre.ListOfOperationsPre;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.models.OperationsData;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ListOfOperationsActivity extends AppCompatActivity {
    ListOfOperationsPre listOfOperationsPre=new ListOfOperationsPre();
     RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<OperationsData> objList;
        String namePlace= Objects.requireNonNull(getIntent().getExtras()).getString("placeName");
        setContentView(R.layout.list_of_operations_activity);

        objList=listOfOperationsPre.loadDataToRecycleView(this, this, namePlace);

        recyclerView=findViewById(R.id.listOperationRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterDetailStatistics(objList));
    }

    public void displayMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
