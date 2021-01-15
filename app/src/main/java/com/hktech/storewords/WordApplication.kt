package com.hktech.storewords

import android.app.Application
import com.hktech.storewords.data.db.WordsDatabase
import com.hktech.storewords.data.repository.WordRepository

/**
 * We want to only have one instance of the database and of the repository in our application.
 * An easy way to achieve this is by creating them as members of the Application class.
 * */

class WordApplication : Application() {

    val database by lazy { WordsDatabase.getDatabase(this) }
    val repository by lazy { WordRepository(database!!.getWordDao()) }

}