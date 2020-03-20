package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Aparies")
public class ApiaryEntity {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "amount_of_honey")
    private int amountOfHoney;

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

    public int getAmountOfHoney() {
        return amountOfHoney;
    }

    public void setAmountOfHoney(int amountOfHoney) {
        this.amountOfHoney = amountOfHoney;
    }
}
