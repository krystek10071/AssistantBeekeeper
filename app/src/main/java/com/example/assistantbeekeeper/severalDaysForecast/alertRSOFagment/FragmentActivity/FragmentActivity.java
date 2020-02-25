package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assistantbeekeeper.R;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentActivity extends Fragment {

    private FragmentActivity listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //assigning layout to FragmentActivity
        View view= inflater.inflate(R.layout.alerts_forecast_fragment, container, false);
        RecyclerView recyclerView= view.findViewById(R.id.recycle_view);
        //optymalization
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        //set adapter
       // recyclerView.setAdapter(new MyAdapter(articles, recyclerView));

        return view;
    }

    public View setRecycleView(){





        return  null;
    }
}
