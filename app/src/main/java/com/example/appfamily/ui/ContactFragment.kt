package com.example.appfamily.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import com.example.appfamily.R
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
        binding.tvMail.isInvisible = true
        binding.etMail.isInvisible = true
        binding.etSubject.isInvisible = true
        binding.tvSubject.isInvisible = true
        binding.etTexto.isInvisible = true
        binding.tvMessage.isInvisible = true
        binding.btnEnviar.isInvisible = true
        binding.btnSalir.isInvisible = true

        binding.ivGmail.setOnClickListener {
            binding.tvMail.isInvisible = false
            binding.etMail.isInvisible = false
            binding.etSubject.isInvisible = false
            binding.tvSubject.isInvisible = false
            binding.etTexto.isInvisible = false
            binding.tvMessage.isInvisible = false
            binding.btnSalir.isInvisible = false
            binding.btnEnviar.isInvisible = false
        }

        binding.btnEnviar.setOnClickListener {
            onIntent(
                binding.etMail.text.toString(),
                binding.etSubject.text.toString(),
                binding.etTexto.text.toString()
            )
        }
    }

    fun onIntent(mail: String, subject: String, message: String){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:" + mail)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        startActivity(intent)
    }
}