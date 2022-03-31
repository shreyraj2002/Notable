package com.example.notable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.notable.Activity.Insert_note;
import com.example.notable.Adapter.NotesAdapter;
import com.example.notable.Model.Notes_DB;
import com.example.notable.ViewModel.NotesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton newNotesButton;
    NotesViewModel notesViewModel;
    RecyclerView notesRecycler;
    NotesAdapter adapter;
    TextView nofilter,hightolow,lowtohigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesButton = findViewById(R.id.newNoteBtn);
        notesRecycler = findViewById(R.id.notesRecycler);

        nofilter = findViewById(R.id.nofilter);
        hightolow = findViewById(R.id.hightolow);
        lowtohigh = findViewById(R.id.lowtohigh);

        nofilter.setBackgroundResource(R.drawable.fliter_selected_shape);

        nofilter.setOnClickListener(v -> {
            loadData(0);
            hightolow.setBackgroundResource(R.drawable.filter_un_shape);
            lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
            nofilter.setBackgroundResource(R.drawable.fliter_selected_shape);
        });
        hightolow.setOnClickListener(v -> {
            loadData(0);
            hightolow.setBackgroundResource(R.drawable.fliter_selected_shape);
            lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
            nofilter.setBackgroundResource(R.drawable.filter_un_shape);
        });
        lowtohigh.setOnClickListener(v -> {
            loadData(0);
            hightolow.setBackgroundResource(R.drawable.filter_un_shape);
            lowtohigh.setBackgroundResource(R.drawable.fliter_selected_shape);
            nofilter.setBackgroundResource(R.drawable.filter_un_shape);
        });

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        newNotesButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Insert_note.class));
        });

        notesViewModel.getAllNotes.observe(this, new Observer<List<Notes_DB>>() {
            @Override
            public void onChanged(List<Notes_DB> notes_dbs) {
                setAdapter(notes_dbs);
            }
        });
    }

    private void loadData(int i) {

        if(i==0){
            notesViewModel.getAllNotes.observe(this, new Observer<List<Notes_DB>>() {
                @Override
                public void onChanged(List<Notes_DB> notes_dbs) {
                    setAdapter(notes_dbs);
                }
            });
        }else if(i==1){
            notesViewModel.highTolow.observe(this, new Observer<List<Notes_DB>>() {
                @Override
                public void onChanged(List<Notes_DB> notes_dbs) {
                    setAdapter(notes_dbs);
                }
            });
        }else if (i==2){
            notesViewModel.lowTohigh.observe(this, new Observer<List<Notes_DB>>() {
                @Override
                public void onChanged(List<Notes_DB> notes_dbs) {
                    setAdapter(notes_dbs);
                }
            });
        }

    }


    public void setAdapter(List<Notes_DB> notes_dbs){
            notesRecycler.setLayoutManager(new GridLayoutManager(this,2));
            adapter = new NotesAdapter(MainActivity.this, notes_dbs);
            notesRecycler.setAdapter(adapter);
    }

}