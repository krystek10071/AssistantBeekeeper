package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.DataModel.AlertsWeatherData;
import com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre.DateParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        TextView timeEventStart=holder.itemView.findViewById(R.id.time_event_start);
        TextView timeEventNight=holder.itemView.findViewById(R.id.time_event_end);
        TextView descriptionEvent=holder.itemView.findViewById(R.id.description_events);

        titleAlert.setText(articles.get(position).getTitle());
        timeEventStart.setText(articles.get(position).getDateStart());
        timeEventNight.setText(articles.get(position).getDateEnd());
        descriptionEvent.setText(articles.get(position).getDescriptioon());


        //TODO
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String date="2020-03-02 08:33:00";
        Date date1=new Date();

        DateParser dateParser=new DateParser(date, "yyyy-MM-dd HH:mm:ss");
        String dateresult=dateParser.parseData("dd-MM");
        Log.i("RESULT STRING FORMAT", dateresult);



    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
