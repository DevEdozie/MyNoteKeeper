package com.example.mynotekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynotekeeper.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
        //set title
        title = "New Note"
        //fab
        binding.fabAddNote.setOnClickListener{
            var title = binding.newNoteTitle.text.toString()
            var note = binding.newNoteText.toString()
            DataManager.addNewNote(title,note)
            //intent
            var intent = Intent(this,NoteListActivity::class.java)
            intent.putExtra(NOTES,DataManager.notes)
            startActivity(intent)
        }
    }
}