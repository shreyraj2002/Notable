package com.example.notable.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notable.Activity.update_notes;
import com.example.notable.MainActivity;
import com.example.notable.Model.Notes_DB;
import com.example.notable.R;
import com.example.notable.databinding.ActivityUpdateNotesBinding;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewholder> {

    MainActivity mainActivity;
    List<Notes_DB> notes_dbs;


    public NotesAdapter(MainActivity mainActivity, List<Notes_DB> notes_dbs) {
        this.mainActivity = mainActivity;
        this.notes_dbs = notes_dbs;
    }

    @Override
    public notesViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new notesViewholder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(notesViewholder holder, int position) {

        Notes_DB note = notes_dbs.get(position);

        switch (note.notesPriority) {
            case "1":
                holder.notesPriority.setBackgroundResource(R.drawable.gree_dot);
                break;
            case "2":
                holder.notesPriority.setBackgroundResource(R.drawable.yellow_dot);
                break;
            case "3":
                holder.notesPriority.setBackgroundResource(R.drawable.red_dot);
                break;
        }

        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubtitle);
        holder.notesDate.setText(note.notesData);

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(mainActivity, update_notes.class);
            intent.putExtra("id",note.id);
            intent.putExtra("title",note.notesTitle);
            intent.putExtra("subtitle",note.notesSubtitle);
            intent.putExtra("priority",note.notesPriority);
            intent.putExtra("notes",note.notes);

            mainActivity.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return notes_dbs.size();
    }

    static class notesViewholder extends RecyclerView.ViewHolder {

        TextView title, subtitle, notesDate;
        View notesPriority;

        public notesViewholder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.notesTitle);
            subtitle = itemView.findViewById(R.id.notesSubtitle);
            notesDate = itemView.findViewById(R.id.notesDate);
            notesPriority = itemView.findViewById(R.id.notesView);
        }
    }
}
