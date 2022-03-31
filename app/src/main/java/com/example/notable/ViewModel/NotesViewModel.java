package com.example.notable.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notable.Model.Notes_DB;
import com.example.notable.Repository.NotesRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {


    public NotesRepository repository;
    public LiveData<List<Notes_DB>> getAllNotes;

    public LiveData<List<Notes_DB>> highTolow;
    public LiveData<List<Notes_DB>> lowTohigh;

    public NotesViewModel(Application application){
        super(application);


        repository = new NotesRepository(application);
        getAllNotes = repository.getallNotes;
        highTolow = repository.highTolow;
        lowTohigh = repository.lowTohigh;
    }

    public void insertNotes(Notes_DB notes){
        repository.insertNote(notes);
    }

    public void deleteNotes(int id){
        repository.deleteNote(id);
    }

     public void updateNotes(Notes_DB notes){
        repository.updateNote(notes);
     }


}
