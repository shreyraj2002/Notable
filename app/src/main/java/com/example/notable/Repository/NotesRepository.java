package com.example.notable.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notable.Dao.Dao;
import com.example.notable.Database.NotesDatabase;
import com.example.notable.Model.Notes_DB;

import java.util.List;

public class NotesRepository {

    public Dao notesDao;
    public LiveData<List<Notes_DB>> getallNotes;

    public LiveData<List<Notes_DB>> highTolow;
    public LiveData<List<Notes_DB>> lowTohigh;


    public NotesRepository(Application application){
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getallNotes = notesDao.getallNotes();
        highTolow = notesDao.highTolow();
        lowTohigh = notesDao.lowTohigh();
    }

    public void insertNote(Notes_DB notes){
        notesDao.insertNotes(notes);
    }

    public void deleteNote(int id){
        notesDao.deleteNotes(id);
    }

    public void updateNote(Notes_DB notes){
        notesDao.updateNotes(notes);
    }

}
