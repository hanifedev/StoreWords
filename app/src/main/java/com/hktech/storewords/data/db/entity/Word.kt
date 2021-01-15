package com.hktech.storewords.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
* To make the Word class meaningful to a Room database, we must annotate it.
* Annotations identify how each part of the Word class relates to an entry in the database.
* Room uses this information to generate code.
*
*  Annotate your class declaration to indicate that the class is an entity.  (@Entity)
* */

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    @ColumnInfo(name = "word")
    val word : String,
    @ColumnInfo(name = "translate")
    val translate : String
    ) {
}