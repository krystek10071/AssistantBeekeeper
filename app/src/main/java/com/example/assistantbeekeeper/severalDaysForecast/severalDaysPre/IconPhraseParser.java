package com.example.assistantbeekeeper.severalDaysForecast.severalDaysPre;

public class IconPhraseParser {

    private static final String phrase1="Słonecznie";
    private static final String phrase2="Przeważnie słonecznie";
    private static final String phrase3="Częściowo słonecznie";
    private static final String phrase4="niewielkie zachmurzenie";
    private static final String phrase5="Zamglone niebo";
    private static final String phrase6="Duże zachmurzenie";
    private static final String phrase7="Zachmurzenie całkowite";
    private static final String phrase8="Zachmurzenie całkowite";
    private static final String phrase11="Mgła";
    private static final String phrase12="Niewielki deszcz";
    private static final String phrase13="Przelotne opady";
    private static final String phrase14="Przelotne opady";
    private static final String phrase15="Burze";
    private static final String phrase16="Przejściowe burze";
    private static final String phrase17="Przejściowe burze";
    private static final String phrase18="Deszcz";
    private static final String phrase19="Przelotny śnieg";
    private static final String phrase20="Słonecznie";

    public String parseNumberIconToPhrase(int numberIcon){
        switch (numberIcon){
            case 1: return phrase1;
            case 2: return phrase2;
            case 3: return phrase3;
            case 4: return phrase4;
            case 5: return phrase5;
            case 6: return phrase6;
            case 7: return phrase7;
            case 8: return phrase8;
            case 11: return phrase11;
            case 12: return phrase12;
            case 13: return phrase13;
            case 14: return phrase14;
            case 15: return phrase15;
            case 16: return phrase16;
            case 17: return phrase17;
            case 18: return phrase18;
            case 19: return phrase19;
            case 20: return phrase20;
        }
        return "";
    }
}
