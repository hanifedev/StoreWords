package com.hktech.storewords.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hktech.storewords.R
import com.hktech.storewords.WordApplication
import com.hktech.storewords.data.db.entity.Word

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddWordFragment : Fragment() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as WordApplication).repository)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_word, container, false)
        val word = root.findViewById<EditText>(R.id.edittext_word)
        val translate = root.findViewById<EditText>(R.id.edittext_translate)
        val button = root.findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val word = word.text.toString()
            val translate = translate.text.toString()
            val model = Word(word,translate)
            wordViewModel.insert(model)
            findNavController().navigate(R.id.action_AddWordFragment_to_HomeFragment)
        }
        return root
    }

}