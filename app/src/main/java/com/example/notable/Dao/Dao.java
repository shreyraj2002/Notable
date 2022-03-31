package com.example.notable.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.notable.Model.Notes_DB;

import java.util.List;

@androidx.room.Dao

public interface Dao {

    @Query("Select * FROM Notes_Database")
    LiveData<List<Notes_DB>>getallNotes();

    @Query("Select * FROM Notes_Database ORDER BY notes_priority DESC")
    LiveData<List<Notes_DB>>highTolow();

    @Query("Select * FROM Notes_Database ORDER BY notes_priority ASC")
    LiveData<List<Notes_DB>>lowTohigh();

    @Insert
    void insertNotes(Notes_DB... notes);

    @Query("DELETE FROM Notes_Database WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes_DB notes);

}
