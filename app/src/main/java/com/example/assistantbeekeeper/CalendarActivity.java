package com.example.assistantbeekeeper;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CalendarActivity extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(R.layout.calendar_activity, container, false);
    }
}
