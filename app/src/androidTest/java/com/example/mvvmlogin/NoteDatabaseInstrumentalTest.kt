package com.example.mvvmlogin

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mvvmlogin.data.notes.NoteDao
import com.example.mvvmlogin.data.notes.NoteDatabase
import com.example.mvvmlogin.data.notes.NoteEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteDatabaseInstrumentalTest {
    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoteDatabase::class.java).build()
        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {

        val noteEntity = NoteEntity(uid = 1, firstName = "Francisco", lastName = "Ramos")
        val noteEntity2 = NoteEntity(uid = 12, firstName = "Martin", lastName = "Ramos Ramos")

        //insert
        noteDao.insertAll(noteEntity = noteEntity)
        noteDao.insertAll(noteEntity = noteEntity2)

        // select all
        val notes = noteDao.getAll()

        //delete the inserted note
        noteDao.delete(noteEntity = noteEntity)
        noteDao.delete(noteEntity = noteEntity2)

        // show on console
        println(notes)
    }
}
