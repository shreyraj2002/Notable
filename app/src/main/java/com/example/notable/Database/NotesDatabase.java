package com.example.notable.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notable.Dao.Dao;
import com.example.notable.Model.Notes_DB;

@androidx.room.Database(entities = {Notes_DB.class}, version = 1)
//Notes_DB is the name of java class
public abstract class NotesDatabase extends RoomDatabase {                  //NotesDatabase is name of the table(entity)

    public abstract Dao notesDao();                              //Dao stands for Data Access Object

    public static NotesDatabase Instance;

    public static NotesDatabase getDatabaseInstance(Context context) {

        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(),
                    NotesDatabase.class,
                    "Notes_Database").allowMainThreadQueries().build();
        }
        return Instance;
    }

}

//RoomDB --> Dao --> Repository --> ViewModel --> Activity_main.xml
// This  is using MVVM(Model View-View Model) concept