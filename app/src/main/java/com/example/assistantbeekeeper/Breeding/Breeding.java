package com.example.assistantbeekeeper.Breeding;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assistantbeekeeper.R;
import com.example.assistantbeekeeper.assistantbeekeepersqllite.MyDbHandler;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Breeding extends AppCompatActivity {

    //declarations
    ListView eventsListView;
    ArrayList<String> listEvents=new ArrayList<>();                                                             //list for widget eventsListView that stores values with to-do items
    ArrayList<Long> listTimeInMillis=new ArrayList<>();                                                         //list with time in Millis
    ArrayList<String> listDescription=new ArrayList<>();                                                        //list with descriptions of activities for beekeeper
    ArrayAdapter arrayAdapter;
    final Long[] timeInMillis=new Long[1];
    TextView dateTextView, nameMonth;                                                                                      //dateTextView with time in millis
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM", Locale.getDefault());
    private SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy", Locale.getDefault());
    //Buttons
    Button addBreedingButton;
    Button setDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);

        MonthCalendar monthCalendar=new MonthCalendar();
        final CompactCalendarView compactCalendarView = findViewById(R.id.compact_calendar_view);
        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendarView.setUseThreeLetterAbbreviation(true);                                              //zmienia nazwy dni na 3 literowe


        //fields
        final MyDbHandler dbHelper=new MyDbHandler(this);
        final BreedingFunctions breedingFunctions=new BreedingFunctions();
        eventsListView= findViewById(R.id.events_listview);
        addBreedingButton=findViewById(R.id.add_breeding_button);

        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, listEvents);
        dateTextView=findViewById(R.id.textView);
        setDateButton=findViewById(R.id.set_time_button);
        nameMonth=findViewById(R.id.calendar_month);


        //if the listEvents is empty then load data from database to listTimeInMillis and listDescription
        if(listEvents.isEmpty()){
            breedingFunctions.readEvents(dbHelper, listTimeInMillis, listDescription);                            //read data from database and save in listTimeInMillis, listDescription
            breedingFunctions.addBreeding(compactCalendarView, listTimeInMillis, listDescription, listEvents, dateTextView);
            eventsListView.setAdapter(arrayAdapter);
            listTimeInMillis.clear();
            listDescription.clear();
        }




        //Add BreedingButton
        addBreedingButton.setOnClickListener(v -> {

            if(dateTextView.getText().toString().equals("NotSetText")){
                Toast.makeText(Breeding.this, "Najpierw musisz ustawic date", Toast.LENGTH_LONG).show();
            }else {
                timeInMillis[0]=Long.parseLong(dateTextView.getText().toString());
                breedingFunctions.addTimeMillisToList(listTimeInMillis, listDescription, timeInMillis[0] );                                //add Date in millis and description to Lists
                breedingFunctions.addBreeding(compactCalendarView, listTimeInMillis, listDescription, listEvents, dateTextView);//add breeding to CompactCalendarView
                eventsListView.setAdapter(arrayAdapter);
                breedingFunctions.addToDatabase(dbHelper,listTimeInMillis, listDescription);                      //add to database
                listTimeInMillis.clear();
                listDescription.clear();
                Toast.makeText(Breeding.this, "Pomyślnie dodano wychów do kalendarza", Toast.LENGTH_LONG).show();

            }

        }
        );

       //setDate Button
        setDateButton.setOnClickListener(view -> {
            breedingFunctions.setBreedingDay(Breeding.this, timeInMillis, dateTextView);
            Log.i("WWDHUWHDUWDH", String.valueOf(dateTextView.getText()));
        });

        //compact calendar view Listener
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                if(compactCalendarView.getEvents(dateClicked)!=null){
                    int length;
                    StringBuilder result= new StringBuilder();
                    List<Event> events = compactCalendarView.getEvents(dateClicked);
                    length=events.size();
                    for(int i=0; i<length; i++){
                        result.append(breedingFunctions.convertString(events.get(i).toString()));
                    }

                    Toast.makeText(Breeding.this, result ,Toast.LENGTH_LONG).show();
                }


            }

            //todo
            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                String nameMon=monthCalendar.setMonthInCalendar(Integer.parseInt(dateFormatMonth.format(firstDayOfNewMonth)));

                actionBar.setTitle(dateFormatYear.format(firstDayOfNewMonth));
                nameMonth.setText(nameMon);

                listEvents.clear();
                listEvents=breedingFunctions.loadEvents(listEvents, compactCalendarView, firstDayOfNewMonth.getTime());
                arrayAdapter.clear();
                arrayAdapter.addAll(listEvents);
                arrayAdapter.notifyDataSetChanged();
                eventsListView.setAdapter(arrayAdapter);
            }
        });

    }


}




