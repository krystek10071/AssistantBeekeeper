package com.example.assistantbeekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

public class Breeding extends AppCompatActivity {

    //CompactCalendarView compactCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);
        final CompactCalendarView compactCalendarView = (CompactCalendarView) findViewById(R.id.compact_calendar_view);
        Event ev1 = new Event(Color.GREEN, 1433701251000L, "Some extra data that I want to store.");
        compactCalendarView.addEvent(ev1);
        Event ev2 = new Event(Color.GREEN, 1571868000000L);
        Event ev3 = new Event(Color.YELLOW, 1571868000000L);
        compactCalendarView.addEvent(ev3);
        compactCalendarView.addEvent(ev2);

    }
}
