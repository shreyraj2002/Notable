package com.example.notable.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_Database")
public class Notes_DB {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "notes_title")
    public String notesTitle;

    @ColumnInfo(name = "notes_Subtitle")
    public String notesSubtitle;

    @ColumnInfo(name = "notes_Date")
    public String notesData;

    @ColumnInfo(name = "notes_Notes")
    public String notes;

    @ColumnInfo(name = "notes_priority")
    public String notesPriority;

}
