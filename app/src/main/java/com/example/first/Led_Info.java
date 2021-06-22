package com.example.first;

public class Led_Info{
    private String LED_STATUS;
    private String STRING_STATUS;

    public Led_Info(){}

    public String getLED_STATUS() {
        return LED_STATUS;
    }
    public void setLED_STATUS(String LED_STATUS){
        this.LED_STATUS = LED_STATUS;
    }
    public String getSTRING_STATUS(){
        return STRING_STATUS;
    }

    public void setSTRING_STATUS(String STRING_STATUS) {
        this.STRING_STATUS = STRING_STATUS;
    }
}
