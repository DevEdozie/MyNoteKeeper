package com.example.mynotekeeper

object DataManager {
    var notes = ArrayList<Schedule>()

    fun addNewNote(title:String,note:String){
        notes.add(Schedule(title,note))
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}