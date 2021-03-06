package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface EarningsDAO {

    @Query("SELECT * FROM Earnings")
    List<EarningsEntity> getAll();

    @Insert
    void insertAll(EarningsEntity... earningsEntities);

    @Delete
    void delete(EarningsEntity earningsEntity);

    @Query("SELECT * FROM Earnings WHERE Data > (:timeFrom) AND Data < (:timeTo) AND idApiary = (:id_apiary)"  )
    List<EarningsEntity> loadCurrentCostsInYear(Long timeFrom, Long timeTo, Long id_apiary);

    @Query("SELECT * FROM Earnings WHERE idApiary = (:id_apiary)")
    List<EarningsEntity> loadProfitByIdApiary(Long id_apiary);


}
