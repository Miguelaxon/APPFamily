package com.example.appfamily.ui

import android.app.ActionBar
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ActionMenuView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appfamily.R
import com.example.appfamily.viewmodel.ViewModel
import com.example.appfamily.ui.adapter.AdapterPictures
import com.example.appfamily.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterPictures()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(context, 1)
        viewModel.returnPicture().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedPictures().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.favorites){
                    it.favorites = false
                    viewModel.updateFavImage(it)
                    Toast.makeText(context, "Isn't favorite", Toast.LENGTH_LONG).show()
                } else {
                    it.favorites = true
                    viewModel.updateFavImage(it)
                    Toast.makeText(context, "Is favorite", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}