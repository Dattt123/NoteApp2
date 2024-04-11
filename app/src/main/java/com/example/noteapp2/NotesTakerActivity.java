package com.example.noteapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.noteapp2.Model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title,edit_Text_notes;
    ImageView imageView_save;
    Notes notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        imageView_save = findViewById(R.id.imageView_save);
        editText_title= findViewById(R.id.editText_title);
        edit_Text_notes = findViewById(R.id.edit_Text_notes);

        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText_title.getText().toString();
                String description = edit_Text_notes.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this,"Vui lòng điền thêm ghi chú!",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE,d MMM yyy HH:mm a");
                Date date = new Date();

                notes = new Notes();

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent= new Intent();
                intent.putExtra("note",notes);

                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }
}