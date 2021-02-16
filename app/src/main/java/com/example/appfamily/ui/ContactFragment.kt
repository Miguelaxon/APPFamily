package com.example.appfamily.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.appfamily.R
import com.example.appfamily.databinding.ContactBinding
import com.example.appfamily.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //activity.getSupportActionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentContactBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivWSP2.setOnClickListener {
            Toast.makeText(context, "Whatsapp", Toast.LENGTH_LONG).show()
        }
        binding.ivGM2.setOnClickListener {
            Toast.makeText(context, "GMAIL", Toast.LENGTH_LONG).show()
        }
    }

}