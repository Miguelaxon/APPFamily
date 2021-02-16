package com.example.appfamily.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import com.example.appfamily.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    private lateinit var binding: FragmentContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMail.isInvisible = false
        binding.etMail.isInvisible = false
        binding.etSubject.isInvisible = false
        binding.tvSubject.isInvisible = false
        binding.etTexto.isInvisible = false
        binding.ivGmail.setOnClickListener {

        }
    }

    fun onIntent(subject: String){
        val intent = Intent(Intent.ACTION_SEND).apply {
            setType("text/html")
        }
    }
}