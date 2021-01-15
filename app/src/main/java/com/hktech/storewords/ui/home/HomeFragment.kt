package com.hktech.storewords.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hktech.storewords.R
import com.hktech.storewords.WordApplication

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory((requireActivity().application as WordApplication).repository)
    }

    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter()

        homeViewModel.allWords.observe(viewLifecycleOwner, {
                words ->
            recyclerView.adapter = adapter
            adapter.setData(words)
        })

        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_AddWordFragment)
        }
        return root
    }

}