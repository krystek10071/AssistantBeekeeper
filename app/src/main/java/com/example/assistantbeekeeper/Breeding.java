package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.assistantbeekeeper.assistantbeekeepersqllite.MyDbHandler;
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
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);
        final CompactCalendarView compactCalendarView = findViewById(R.id.compact_calendar_view);

        //fields
        eventsListView= findViewById(R.id.events_listview);
        addBreedingButton=findViewById(R.id.add_breeding_button);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEvents);
        MyDbHandler dbHelper=new MyDbHandler(getApplicationContext());

        ////////////////////////////////////Listeners/////////////////////////////////////////////////////

        addBreedingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                addBreeding(compactCalendarView, 1572303600000L);
                eventsListView.setAdapter(arrayAdapter);

            }
        }
        );


    }






    private void addBreeding(CompactCalendarView compactCalendarView, long timeInMillis ){

            //time1...time4 this is time for individual activities
            long time=timeInMillis;                                                                                 //set the current time
            long constTime=86400000;                                                                                //milisecunds in one day
            long time1=time+constTime;
            long time2=time+(12*constTime);
            long time3=time+(13*constTime);
            long time4=time+(14*constTime);

            addEvent(compactCalendarView, Color.RED, time1, "Przenies larwy do miseczek matecznikowych");
            addEvent(compactCalendarView, Color.RED, time2, "Umiesc je w klateczka pomiedzy z plastrami z czerwiem");
            addEvent(compactCalendarView, Color.RED, time3, "Wygryzienie sie matek");
            addEvent(compactCalendarView, Color.RED, time4, "Znakowanie matek i umieszczenie ich z rodziną wychowującą");

    }

    private void addEvent (CompactCalendarView compactCalendarView, int color, long timeInMillis, Object data){
        Event ev1=new Event(color, timeInMillis,data);
        compactCalendarView.addEvent(ev1);
        helpDate.setTime(timeInMillis);
        listEvents.add(helpDate.toString() + data);
    }

}




















