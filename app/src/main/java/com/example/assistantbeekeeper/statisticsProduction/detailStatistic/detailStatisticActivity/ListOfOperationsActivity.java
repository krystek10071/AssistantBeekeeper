package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.statisticsProduction.detailStatistic.detailStatisticPre.ListOfOperationsPre;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class ListOfOperationsActivity extends AppCompatActivity {
    ListOfOperationsPre listOfOperationsPre=new ListOfOperationsPre();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_operations_activity);
        recyclerView.findViewById(R.id.listOperationRecycler);

        listOfOperationsPre.loadDataToRecycleView();

    }
}
