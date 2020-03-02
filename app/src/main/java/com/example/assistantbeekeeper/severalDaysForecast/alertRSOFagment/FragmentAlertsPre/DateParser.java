package com.example.assistantbeekeeper.severalDaysForecast.alertRSOFagment.FragmentAlertsPre;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {
    private static final String TAG="DateParser";
    private String dateInString;
    private String pattern;

    public DateParser(String dateInString, String pattern) {
        this.dateInString = dateInString;
        this.pattern = pattern;
    }

    public String parseData(String patternForConversion){
        Date date;
        String resultStringData=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern, Locale.getDefault());
        SimpleDateFormat formatForConvertion=new SimpleDateFormat(patternForConversion, Locale.getDefault());
        try {
            date=simpleDateFormat.parse(dateInString);
            resultStringData=formatForConvertion.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            Log.i(TAG, "Error parse Date");
        }

        if(resultStringData!=null){
            return resultStringData;
        }

        return "";
    }



}
