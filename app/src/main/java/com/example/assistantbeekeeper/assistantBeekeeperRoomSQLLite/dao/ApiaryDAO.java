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

    @Query("UPDATE Aparies SET amount_of_honey = (:amountOfHoney) WHERE id = (:id_Apiary) ")
    void changeAmountOfHoney(Long id_Apiary, int amountOfHoney);


}
