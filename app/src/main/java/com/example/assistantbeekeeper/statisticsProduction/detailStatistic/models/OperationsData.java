package com.example.assistantbeekeeper.statisticsProduction.detailStatistic.models;

public class OperationsData implements Comparable<OperationsData>{
    private Long timeInMillis;
    private String date;
    private String description;
    private String value;

    public Long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(OperationsData operationsData) {
        return this.timeInMillis.compareTo(operationsData.timeInMillis);
    }
}
