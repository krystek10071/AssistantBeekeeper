package com.example.assistantbeekeeper;

import android.content.ContentValues;
import android.database.Cursor;
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
                addBreeding(compactCalendarView, dbHelper ,1572303600000L);
                 eventsListView.setAdapter(arrayAdapter);
            }
        }
        );
    }








}




















