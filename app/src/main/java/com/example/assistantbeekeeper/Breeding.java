package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Date;

public class Breeding extends AppCompatActivity {

    ListView eventsListView;
    Date date=new Date();
    Date helpDate=new Date();
    ArrayList<String> listEvents=new ArrayList<>();

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);

        final CompactCalendarView compactCalendarView = findViewById(R.id.compact_calendar_view);
        eventsListView= findViewById(R.id.events_listview);
        date.setTime(1433701251000L);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Event ev1 = new Event(Color.GREEN, 1433701251000L, "Some extra data that I want to store.");
        compactCalendarView.addEvent(ev1);
        listEvents.add(date.toString()  +  "Wywoz obornika");
        addEvent(compactCalendarView, Color.GREEN, 1433701251000L , "Kolejne swieto nieudacznikow");
        addEvent(compactCalendarView, Color.GREEN, 1433701251000L , "Kolejne swieto nieudacznikow");
        addEvent(compactCalendarView, Color.GREEN, 1433701251000L , "Kolejne swieto nieudacznikow");
        addEvent(compactCalendarView, Color.GREEN, 1433701251000L , "Kolejne swieto nieudacznikow");




        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEvents);
        eventsListView.setAdapter(arrayAdapter);

    }


    public void addEvent(CompactCalendarView compactCalendarView, int color , long timeInMillis, Object data ){
            Event ev1=new Event(color, timeInMillis,data);
            compactCalendarView.addEvent(ev1);
            helpDate.setTime(timeInMillis);
            listEvents.add(helpDate.toString() + data);
    }
}




















