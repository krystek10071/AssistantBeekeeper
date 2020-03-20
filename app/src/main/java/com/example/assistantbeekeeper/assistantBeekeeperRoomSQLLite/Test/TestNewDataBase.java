package com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.Test;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dao.EarningsDAO;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.dbHandler.AssistantDbAbstract;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.ApiaryEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.CostEntity;
import com.example.assistantbeekeeper.assistantBeekeeperRoomSQLLite.models.EarningsEntity;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


@SuppressLint("Registered")
public class TestNewDataBase extends AppCompatActivity {

     private AssistantDbAbstract database;
    List<ApiaryEntity> apiaryListItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database= Room.databaseBuilder(this, AssistantDbAbstract.class, "mydb").
                allowMainThreadQueries().build();

        ApiaryEntity apiaryEntity=new ApiaryEntity();
        CostEntity costEntity=new CostEntity();
        EarningsEntity earningsEntity=new EarningsEntity();


        apiaryEntity.setName("Moje pole");
        apiaryEntity.setAmountOfHoney(1000);
        database.apiaryDAO().insertAll(apiaryEntity);

    }


}
