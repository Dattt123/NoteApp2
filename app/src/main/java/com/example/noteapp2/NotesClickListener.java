package com.example.noteapp2;

import androidx.cardview.widget.CardView;

import com.example.noteapp2.Model.Notes;

public interface NotesClickListener{
        void onClick(Notes notes);
        void onLongClick(Notes notes, CardView cardView);
}
