package com.example.assistantbeekeeper.severalDaysForecast;

import java.util.Calendar;

 class WeekDay {



     String getNameWeekday(long timeInMillis) {
        String nameWeekday;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        int numberDayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);
        nameWeekday=NameWeekday(numberDayOfWeek);

        return nameWeekday;
    }


    private String NameWeekday(int number){
        switch (number){
            case 7:
                return "pon.";
            case 1:
                return "wt.";
            case 2:
                return "śr.";
            case 3:
                return "czw.";
            case 4:
                return "pt.";
            case 5:
                return "sob";
            case 6:
                return "niedz";
        }
        return null;
    }


}
