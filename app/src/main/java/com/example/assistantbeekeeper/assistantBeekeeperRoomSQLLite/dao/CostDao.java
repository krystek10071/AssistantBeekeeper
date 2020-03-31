package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CostDao {

    @Query("SELECT * FROM Costs")
    List<CostEntity> getAll();

    @Insert
    void insertAll(CostEntity ... costEntities);

    @Delete
    void delete(CostEntity costEntity);

    @Query("SELECT * FROM Costs WHERE Data > (:timeFrom) AND Data < (:timeTo) AND id_apiary_entity = (:id_apiary)"  )
    List<CostEntity> loadCurrentCostsInYear(Long timeFrom, Long timeTo, Long id_apiary);
}
