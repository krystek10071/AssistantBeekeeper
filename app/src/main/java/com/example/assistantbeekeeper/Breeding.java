package com.example.assistantbeekeeper;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.assistantbeekeeper.assistantbeekeepersqllite.MyDbHandler;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class Breeding extends AppCompatActivity {

    //declarations
    ListView eventsListView;
    ArrayList<String> listEvents=new ArrayList<>();
    ArrayList<Long> listTimeInMillis=new ArrayList<>();
    ArrayList<String> listDescription=new ArrayList<>();
    Button addBreedingButton;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);
        final CompactCalendarView compactCalendarView = findViewById(R.id.compact_calendar_view);

    //fields
        final MyDbHandler dbHelper=new MyDbHandler(this);
        final BreedingFunctions breedingFunctions=new BreedingFunctions();
        eventsListView= findViewById(R.id.events_listview);
        addBreedingButton=findViewById(R.id.add_breeding_button);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEvents);

        breedingFunctions.addTimeMillisToList(listTimeInMillis, listDescription);                                //add Date in millis and description to Lists


        ////////////////////////////////////Buttons Add Breeding////////////////////////////////////

        addBreedingButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                breedingFunctions.addBreeding(compactCalendarView, listTimeInMillis, listDescription, listEvents);
                eventsListView.setAdapter(arrayAdapter);
                breedingFunctions.addToDatabase(dbHelper,listTimeInMillis, listDescription);

            }
        }
        );
    }


}




