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
    var option: Int = 0

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

        binding.ivWsp.setOnClickListener {
            binding.tvMail.isInvisible = true
            binding.etMail.isInvisible = true
            binding.etSubject.isInvisible = true
            binding.tvSubject.isInvisible = true
            binding.etTexto.isInvisible = false
            binding.etTexto.text.clear()
            binding.tvMessage.isInvisible = false
            binding.btnEnviar.isInvisible = false
            binding.btnSalir.isInvisible = false
            option = 1
        }

        binding.ivGmail.setOnClickListener {
            binding.tvMail.isInvisible = false
            binding.etMail.isInvisible = false
            binding.etMail.text.clear()
            binding.etSubject.isInvisible = false
            binding.etSubject.text.clear()
            binding.tvSubject.isInvisible = false
            binding.etTexto.isInvisible = false
            binding.etTexto.text.clear()
            binding.tvMessage.isInvisible = false
            binding.btnSalir.isInvisible = false
            binding.btnEnviar.isInvisible = false
            option = 0
        }

        binding.btnEnviar.setOnClickListener {
            if (option == 0) {
                onIntent(
                    binding.etMail.text.toString(),
                    binding.etSubject.text.toString(),
                    binding.etTexto.text.toString())
            } else if (option == 1) {
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    type = "text/plain"
                    val uri = "whatsapp://send?phone=56951316411"
                    data = Uri.parse(uri)
                    putExtra(Intent.EXTRA_TEXT, binding.etTexto.text.toString())
                    setPackage("com.whatsapp")
                }
                startActivity(intent)
            }
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