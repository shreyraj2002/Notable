package com.example.notable.Activity;

import static android.text.format.DateFormat.format;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.example.notable.Model.Notes_DB;
import com.example.notable.R;
import com.example.notable.ViewModel.NotesViewModel;
import com.example.notable.databinding.ActivityInsertNoteBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Insert_note extends AppCompatActivity {

    ActivityInsertNoteBinding binding;
    String title,subtitle,notes;
    NotesViewModel notesViewModel;
    String priority = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);


        binding.greenPriority.setOnClickListener(v -> {
            binding.greenPriority.setImageResource(R.drawable.done);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(0);
            priority = "1";
        });

        binding.yellowPriority.setOnClickListener(v -> {
            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(R.drawable.done);
            binding.redPriority.setImageResource(0);
            priority = "2";
        });

        binding.redPriority.setOnClickListener(v -> {
            binding.greenPriority.setImageResource(0);
            binding.yellowPriority.setImageResource(0);
            binding.redPriority.setImageResource(R.drawable.done);
            priority = "3";
        });


        binding.doneNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = binding.notesTitle.getText().toString();
                subtitle = binding.notesSubtitle.getText().toString();
                notes = binding.notesDate.getText().toString();

                CreateNotes(title,subtitle,notes);

            }

            private void CreateNotes(String title, String subtitle, String notes) {

                Date date = new Date();
                CharSequence sequence = DateFormat.format("MMMM d,yyyy",date.getTime());


                Notes_DB notes1 = new Notes_DB();
                notes1.notesTitle = title;
                notes1.notesSubtitle = subtitle;
                notes1.notesData= sequence.toString();      //notes Date
                notes1.notes = notes;
                notes1.notesPriority = priority;

                notesViewModel.insertNotes(notes1);

                Toast.makeText(Insert_note.this,"Notes Created", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}