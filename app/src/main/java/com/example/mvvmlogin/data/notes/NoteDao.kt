package com.example.mvvmlogin.data.notes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmlogin.utils.Constants

@Dao
interface NoteDao {
    @Query("SELECT * FROM ${ Constants.NOTE_DATABASE_NAME }")
    fun getAll(): List<NoteEntity>

    @Insert
    fun insertAll(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)
}
