package com.example.mynotekeeper

object DataManager {
    var notes = ArrayList<Schedule>()

    fun addNewNote(title:String,note:String){
        notes.add(Schedule(title,note))
    }

}