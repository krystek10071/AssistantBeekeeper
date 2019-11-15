package com.example.assistantbeekeeper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.assistantbeekeeper.assistantbeekeepersqllite.FeedReaderContract;
import com.example.assistantbeekeeper.assistantbeekeepersqllite.MyDbHandler;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class Breeding extends AppCompatActivity {

    //declarations
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
        final MyDbHandler dbHelper=new MyDbHandler(this);

        ////////////////////////////////////////Listeners/////////////////////////////////////////////////////
        ////////////////////////////////////Buttons Add Breeding/////////////////////////////////////////////////

        addBreedingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SQLiteDatabase db=dbHelper.getWritableDatabase();

                addBreeding(compactCalendarView, 1572303600000L);
                eventsListView.setAdapter(arrayAdapter);

                ContentValues values2=new ContentValues();
                ContentValues values1=new ContentValues();

                values1.put(FeedReaderContract.EventsCalendar.COL1, "Zapisano wartosc daty do tabeli Events Calendar");
                values2.put(FeedReaderContract.TestTable.COL1,"Zapisano do bazy wartosc daty do tabeli TableTest");
                long newRowID=db.insert(FeedReaderContract.EventsCalendar.TABLE_NAME, null, values1);
                long newRowID1=db.insert(FeedReaderContract.TestTable.TABLE_NAME, null, values2);
                Log.i("WPIS DO TABELI EVENTS CALENDAR ", Long.toString(newRowID));
                Log.i("WPIS DO TABELI TESTTABLE ", Long.toString(newRowID1));



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
    //add event to compactCalendarView &&
    private void addEvent (CompactCalendarView compactCalendarView, int color, long timeInMillis, Object data){
        Event ev1=new Event(color, timeInMillis,data);
        compactCalendarView.addEvent(ev1);
        helpDate.setTime(timeInMillis);
        listEvents.add(helpDate.toString() + data);
    }

}




















