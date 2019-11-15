package com.example.assistantbeekeeper.assistantbeekeepersqllite;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract(){}

    //Table EVEBTS_CALENDAR
    public static class EventsCalendar implements BaseColumns{
        public static final String TABLE_NAME="EVENTS_CALENDAR";
        public static final String COL1="DATE";
        public static final String COL2="ACTION";

    }



    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EventsCalendar.TABLE_NAME + " (" +
                    EventsCalendar._ID + " INTEGER PRIMARY KEY," +
                    EventsCalendar.COL1 + " TEXT," +
                    EventsCalendar.COL2 + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EventsCalendar.TABLE_NAME;

}
