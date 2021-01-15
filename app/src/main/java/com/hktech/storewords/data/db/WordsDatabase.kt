package com.hktech.storewords.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hktech.storewords.data.db.dao.WordDao
import com.hktech.storewords.data.db.entity.Word
import com.hktech.storewords.data.db.WordsDatabase as WordsDatabase

/**
* Room uses the DAO to issue queries to its database.
* Annotate the class to be a Room database.
* Declare the entities that belong in the database
* */

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordsDatabase : RoomDatabase() {

    //Define the DAOs that work with the database.
    abstract fun getWordDao(): WordDao

    // WordsDatabase as a singleton to prevent having multiple instances of the database opened at the same time
    companion object {

        private var INSTANCE : WordsDatabase? = null
        private const val DB_NAME = "word_database.db"

        fun getDatabase(context : Context) : WordsDatabase? {
            //if INSTANCE == null
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, WordsDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    }
}