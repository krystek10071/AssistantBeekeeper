package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName="Costs",
        foreignKeys=@ForeignKey(entity = ApiaryEntity.class,
                parentColumns ="id" ,
                childColumns ="idApiaryEntity",
                onDelete = CASCADE,
                onUpdate = CASCADE),
        indices = @Index("idApiaryEntity")

)
public class CostEntity {
    @PrimaryKey
    private Long id;
    private String name;
    private Double value;
    private Long idApiaryEntity;
    private String Data;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getIdApiaryEntity() {
        return idApiaryEntity;
    }

    public void setIdApiaryEntity(Long idApiaryEntity) {
        this.idApiaryEntity = idApiaryEntity;
    }


    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
