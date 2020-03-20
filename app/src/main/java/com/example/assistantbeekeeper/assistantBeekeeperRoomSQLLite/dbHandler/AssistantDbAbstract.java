package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao.ApiaryDAO;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao.CostDao;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao.EarningsDAO;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ApiaryEntity.class, CostEntity.class, EarningsEntity.class}, version = 1, exportSchema = false)
public abstract class AssistantDbAbstract extends RoomDatabase {
    public abstract ApiaryDAO apiaryDAO();
    public abstract CostDao costDao();
    public abstract EarningsDAO earningsDAO();
}
