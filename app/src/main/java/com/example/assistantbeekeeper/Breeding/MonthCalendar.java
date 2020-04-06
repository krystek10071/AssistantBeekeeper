package com.example.assistantbeekeeper.Breeding;

public class MonthCalendar {
    private static final String month1="Styczeń";
    private static final String month2="Luty";
    private static final String month3="Marzec";
    private static final String month4="Kwiecień";
    private static final String month5="Maj";
    private static final String month6="Czerwiec";
    private static final String month7="Lipiec";
    private static final String month8="Sierpień";
    private static final String month9="Wrzesień";
    private static final String month10="Październik";
    private static final String month11="Listopad";
    private static final String month12="Grudzień";

    public String setMonthInCalendar(int monthNumber){
        switch (monthNumber){
            case 1 :{
                return month1;
            }

            case 2:{
                return month2;
            }

            case 3:{
                return month3;
            }

            case 4:{
                return month4;
            }

            case 5:{
                return month5;
            }

            case 6:{
                return month6;
            }

            case 7:{
                return month7;
            }

            case 8:{
                return month8;
            }

            case 9:{
                return month9;
            }

            case 10:{
                return month10;
            }

            case 11:{
                return month11;
            }

            case 12:{
                return month12;
            }

        }
        return "";
    }
}
