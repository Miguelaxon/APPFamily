package com.example.appfamily.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appfamily.R
import com.example.appfamily.viewmodel.ViewModel
import com.example.appfamily.ui.adapter.AdapterFamily
import com.example.appfamily.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = AdapterFamily()
        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(context, 1)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_favoritesFragment)
        }

        binding.fab2.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_contactFragment)
        }

        viewModel.allFamily.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedFamily().observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.selectedPicture(it.name)
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })
    }
}