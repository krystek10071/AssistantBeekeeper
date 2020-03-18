package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Aparies")
public class ApiaryEntity {

    @PrimaryKey (autoGenerate = true)
    private Long id;
    private String name;
    private Long amountOfHoney;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmountOfHoney() {
        return amountOfHoney;
    }

    public void setAmountOfHoney(Long amountOfHoney) {
        this.amountOfHoney = amountOfHoney;
    }
}
