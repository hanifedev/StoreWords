package com.hktech.storewords.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hktech.storewords.data.db.entity.Word
import com.hktech.storewords.data.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}
