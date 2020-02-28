package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.DataModel.AlertsWeatherData;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<AlertsWeatherData> articles;


     MyAdapter(ArrayList<AlertsWeatherData> articles) {
        this.articles=articles;
    }
    @Nullable
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View alertsRow=layoutInflater.inflate(R.layout.recycleview_alerts_details, parent, false);
        return new MyViewHolder(alertsRow);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        TextView titleAlert=holder.itemView.findViewById(R.id.title_alert);
        TextView province=holder.itemView.findViewById(R.id.province);
        TextView timeEvent=holder.itemView.findViewById(R.id.time_event);
        TextView descriptionEvent=holder.itemView.findViewById(R.id.description_events);

        titleAlert.setText(articles.get(position).getTitle());
        province.setText(articles.get(position).getProvincy());
        timeEvent.setText(articles.get(position).getDateStart());
        descriptionEvent.setText(articles.get(position).getDescriptioon());

        
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
