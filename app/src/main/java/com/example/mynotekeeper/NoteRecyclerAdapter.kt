package com.example.mynotekeeper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerAdapter(private val context: Context, private val notes: ArrayList<Schedule>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate content layout into recyclerview
        val itemView = layoutInflater.inflate(R.layout.list_content, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //get individual note
        val note = notes[position]
        //set title
        holder.title?.text = note.title
        //position
        holder.notePosition = position
    }

    override fun getItemCount() = notes.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //initialise views
        val title = itemView?.findViewById<TextView>(R.id.title_textView)
        val delImage = itemView?.findViewById<ImageView>(R.id.delete_icon)
        var notePosition = 0

        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }

        init {
            delImage?.setOnClickListener {
                notes.removeAt(notePosition)
                Toast.makeText(context, "Note deleted", Toast.LENGTH_LONG).show()
            }
        }
    }
}