package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Breeding extends AppCompatActivity {

    ListView eventsListView;
    Date helpDate=new Date();
    ArrayList<String> listEvents=new ArrayList<>();
    Button addBreedingButton;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);

        final CompactCalendarView compactCalendarView = findViewById(R.id.compact_calendar_view);
        final Calendar calendar;

        eventsListView= findViewById(R.id.events_listview);
        addBreedingButton=findViewById(R.id.add_breeding_button);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        addBreedingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        }
        );


        Event ev1 = new Event(Color.GREEN, 1433701251000L, "Some extra data that I want to store.");
        compactCalendarView.addEvent(ev1);
        addEvent(compactCalendarView, Color.GREEN, 1433701251000L , "Kolejne swieto nieudacznikow");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEvents);
        eventsListView.setAdapter(arrayAdapter);
    }


    private void addEvent(CompactCalendarView compactCalendarView, int color , long timeInMillis, Object data ){

            long time=timeInMillis;                                                                                 //set the current time
            long constTime=86400000;                                                                                //milisecunds in one day




            Event ev1=new Event(color, timeInMillis,data);
            compactCalendarView.addEvent(ev1);
            helpDate.setTime(timeInMillis);
            listEvents.add(helpDate.toString() + data);
    }

}




















