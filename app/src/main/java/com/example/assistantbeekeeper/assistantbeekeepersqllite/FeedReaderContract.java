package com.example.assistantbeekeeper.assistantbeekeepersqllite;

import android.provider.BaseColumns;
import android.provider.Telephony;

public final class FeedReaderContract {
    private FeedReaderContract(){}

    //Table EVEBTS_CALENDAR
    public static class EventsCalendar implements BaseColumns{
        public static final String TABLE_NAME="EVENTS_CALENDAR";
        public static final String COL1="DATE";
        public static final String COL2="ACTION";

    }

    //Table Test_Table
    public static class TestTable implements BaseColumns{
        public static final String TABLE_NAME="TEST_TABLE";
        public static final String COL1="DESCRIPTION" ;
    }



    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EventsCalendar.TABLE_NAME + " (" +
                    EventsCalendar._ID + " INTEGER PRIMARY KEY," +
                    EventsCalendar.COL1 + " TEXT," +
                    EventsCalendar.COL2 + " TEXT)"+"   "+
                    "CREATE TABLE " + TestTable.TABLE_NAME +" ("+
                    TestTable._ID + " INTEGER PRIMARY KEY,"+
                    TestTable.COL1+ " TEXT)";


    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EventsCalendar.TABLE_NAME+
            "DROP TABLE IF EXISTS " + TestTable.TABLE_NAME;

}
