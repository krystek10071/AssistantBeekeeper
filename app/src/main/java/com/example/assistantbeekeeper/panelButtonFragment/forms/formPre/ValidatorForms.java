package com.example.assistantbeekeeper.panelButtonFragment.forms.formPre;

import java.util.regex.Pattern;

public class ValidatorForms {

    private static final Pattern VALUE_INPUT_PATTERN=
            Pattern.compile("^"+
                    "(.*[0-9])"+
                    "$");


    public String validInputName(String inputName) {
        if(inputName.length()>15){
            return "Nazwa jest zbyt dluga";
        }
        return inputName;
    }

    public String validInputValue(String inputValue) {
        if(inputValue.length()>15){
            return "Liczba znakow jest zbyt dużą";
        }
        else if (!(VALUE_INPUT_PATTERN.matcher(inputValue).matches())){
            return "Nie dozwolone znaki";
        }
        return inputValue;
    }

}
