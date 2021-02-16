package com.example.appfamily.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appfamily.databinding.FragmentFavoritesBinding
import com.example.appfamily.ui.adapter.AdapterFavorites
import com.example.appfamily.viewmodel.ViewModel

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterFavorites()
        binding.rv3.adapter = adapter
        binding.rv3.layoutManager = GridLayoutManager(context, 2)

        viewModel.returnFavorites().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedFavorites().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.favorites){
                    it.favorites = false
                    viewModel.updateFavImage(it)
                    Toast.makeText(context, "Isn't favorite", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}