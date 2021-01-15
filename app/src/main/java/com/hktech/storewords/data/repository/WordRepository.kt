package com.hktech.storewords.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.hktech.storewords.data.db.dao.WordDao
import com.hktech.storewords.data.db.entity.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
*  The Repository implements the logic for deciding whether to fetch data from a network or use results cached in the local database.
*
* The DAO is passed into the repository constructor as opposed to the whole database.
* This is because it only needs access to the DAO, since the DAO contains all the read/write methods for the database.
* There's no need to expose the entire database to the repository.
* */
class WordRepository(private val wordDao: WordDao) {

    val allWords : LiveData<MutableList<Word>> = wordDao.getAllWords()


    /**
    * The suspend modifier tells the compiler that this needs to be called from a coroutine or another suspending function.
      Room executes suspend queries off the main thread.
    * */
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        withContext(Dispatchers.IO) {
            wordDao.insert(word)
        }
    }

}