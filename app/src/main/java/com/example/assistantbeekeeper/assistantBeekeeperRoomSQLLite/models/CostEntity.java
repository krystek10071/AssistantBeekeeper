package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName="Costs",
        foreignKeys=@ForeignKey(entity = ApiaryEntity.class,
                parentColumns ="id" ,
                childColumns ="id_apiary_entity",
                onDelete = CASCADE,
                onUpdate = CASCADE),
        indices = @Index("id_apiary_entity")

)
public class CostEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "value")
    private Double value;

    @ColumnInfo(name="id_apiary_entity")
    private Long idApiaryEntity;

    @ColumnInfo(name = "Data")
    private Long Data;

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


    public Long getData() {
        return Data;
    }

    public void setData(Long data) {
        Data = data;
    }
}
