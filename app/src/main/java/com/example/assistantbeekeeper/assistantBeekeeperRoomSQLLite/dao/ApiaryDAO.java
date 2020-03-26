package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ApiaryDAO {

    @Query("SELECT * FROM Aparies")
    List<ApiaryEntity> getAll();

    @Insert
    void insertAll(ApiaryEntity ... apiaryEntities);

    @Delete
    void delete(ApiaryEntity apiaryEntity);

    @Query("SELECT * FROM Aparies WHERE name = (:placeName)")
    List<ApiaryEntity> getIdApiaryByName(String placeName);
}
