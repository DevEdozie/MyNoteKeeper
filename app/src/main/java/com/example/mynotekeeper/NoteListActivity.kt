package com.example.mynotekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotekeeper.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        title = "Notes"
        displayDemo()

        binding.fab.setOnClickListener { view ->

            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }
        //recyclerview
        binding.listItems.layoutManager = LinearLayoutManager(this)
        //set recyclerview adapter
        binding.listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes)
    }

    fun displayDemo(){
        var noteIsEmpty = DataManager.notes.size == 0
        if(noteIsEmpty){
            binding.noNote.text = "Create new note"
        }else{
            binding.noNote.text = ""
        }
    }


    override fun onResume() {
        super.onResume()
        displayDemo()
        binding.listItems.adapter?.notifyDataSetChanged()
    }

}