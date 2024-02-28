package com.example.mvvmlogin.data.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// https://developer.android.com/training/data-storage/room?hl=es-419#kts
@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "title") val firstName: String,
    @ColumnInfo(name = "body") val lastName: String
)

