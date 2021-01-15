package com.hktech.storewords.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hktech.storewords.data.db.entity.Word
import com.hktech.storewords.data.repository.WordRepository
import kotlinx.coroutines.launch

/*
* The ViewModel's role is to provide data to the UI
* A ViewModel acts as a communication center between the Repository and the UI.
* You can also use a ViewModel to share data between fragments.
* */
class HomeViewModel(private val repository: WordRepository) : ViewModel() {

    val allWords: LiveData<MutableList<Word>> = repository.allWords


    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}

