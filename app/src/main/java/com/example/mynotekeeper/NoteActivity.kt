package com.example.mynotekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mynotekeeper.databinding.ActivityNoteBinding
import com.google.android.material.snackbar.Snackbar

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding
    private var notePosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
        //set title
        title = "New Note"
        displayNote()
        //fab
        binding.fabAddNote.setOnClickListener { view ->
            var title = binding.newNoteTitle.text.toString()
            var note = binding.newNoteText.toString()
            DataManager.addNewNote(title, note)
            //display snackbar
            Toast.makeText(this, "Note Successfully Created", Toast.LENGTH_LONG).show()
            //intent
            var intent = Intent(this, NoteListActivity::class.java)
            //intent.putExtra(NOTES,DataManager.notes)
            startActivity(intent)
        }
    }

    fun displayNote(){
        notePosition = intent.getIntExtra(NOTE_POSITION,-1)?: -1
        if(notePosition != -1){
            val note = DataManager.notes[notePosition]
            binding.newNoteTitle.setText(note.title)
            binding.newNoteText.setText(note.note)
        }
    }
}