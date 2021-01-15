package com.hktech.storewords.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hktech.storewords.data.db.entity.Word

/**
* Annotate the class declaration with @Dao to identify the class as a DAO class for Room.
* */

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word : Word)

    @Delete
    fun delete(word : Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords() : LiveData<MutableList<Word>>
}