package com.example.appfamily.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfamily.ClassFamily
import com.example.appfamily.ClassPictures
import com.example.appfamily.databinding.ItemFamilyBinding

class AdapterFamily: RecyclerView.Adapter<AdapterFamily.FamilyViewHolder>() {
    private var listFamily = listOf<ClassFamily>()
    private var selectedFamily = MutableLiveData<ClassFamily>()

    fun selectedFamily(): LiveData<ClassFamily> = selectedFamily

    fun update(list: List<ClassFamily>){
        listFamily = list
        notifyDataSetChanged()
    }

    inner class FamilyViewHolder(private val binding: ItemFamilyBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bind(classFamily: ClassFamily){
            var urlImage: String = ""
            binding.tvMembers.text = classFamily.name.toUpperCase()
            when (classFamily.name) {
                "Jose Miguel" -> {
                    urlImage = "https://lh3.googleusercontent.com/jh3esoXKZsjAYlsbDB6ZojXWSfKE1dic" +
                            "fsLzP-bkXE7hU4dw1VxE-Fj62-ePFSmG1y_9y50XzaXp8JtFChX-1sf-ZRhH3AnwwXG3q" +
                            "TgEo3TxuQyhfuOSscPJho2euQ3QkZ8DuxKI9hjxQ-nPmmcI6S-XkpW4xnygqBh7Jegk1p" +
                            "8M7U2xLg4R6Kn38y_LA-m8hEhht1MqZLb6lvKwGaP04qhKQoyxr3bqPv2EdzBlIPoPezU" +
                            "sg6YR-lQRoXTWeLdmXDZ_faKZ0iCcw97aTWeYQsAW0vi1Idgv5N9yn7eeWetT83FnGYpE" +
                            "uxgJiP356fuMW2uxlu3ShwHzS5c_isTGXwBHIxLZ4-4dYk3u0F0G-VURmuLxy8q3aHm2V" +
                            "PtdbOzFjV40rVYoTpcuERvs8v_RJM-09npf25Up44OoDW2TkyJ6Qr5QO8e7Z1pbm2WmWa" +
                            "bCXSfmCCOv2JxTJfxZn4rWYkjHQrUAyZYxJBgNiyWyPlWRM8oCo7I-luSdrTN5V_kwOET" +
                            "9Bhzut9EQhrDYaKONuRnUPygOId_1pyPPDRo7zbd4K6YLSwj_-iU4q42dgC1p6QO6d1zL" +
                            "4evEy37ZeFCtXhpCNMMSbYQJzhkaoL_0XBC0FkiBewE5jKECW77PfVybD4wKNkSntffel" +
                            "jFPyU5TWOl4CGgb8ctaYZHk_tmgmUpOnybeGbkhHNmxvLvVbx0=w471-h627-no?" +
                            "authuser=0"
                }
                "Laura Victoria" -> {
                    urlImage = "https://lh3.googleusercontent.com/EBZZbhqUxrukCiNyISwEbTYwoUHQzVUR5D" +
                            "T47hEDSQaLeBI284aOQ4gRKhMYRjgsLbSsV48NwHr2V-igI1Zz0ynf2h32tyPPzVy-wlR7w" +
                            "YHgLP6eZwi1lwUOtenYy7tyQ-GmMTJvmoTwks10FrktfEpg19IOa5OrI6IiQ1mYvtjXUiI1" +
                            "hSrKViAp5TKuQ8YJkgyY3c5TcO9f-6HG9FN_mwQK8P0R2rWMdXwZABBrHSg-DmVLzS0pGAL" +
                            "McZ3WqsvxTNU-w8wTdhndY8t1EOsydTtHIA2k_q8-Tf-2Ik0NWCxB2x9HtpkoKNFen7KvNf" +
                            "XnTU35j2yEQwpsNJ7eUHJTNNdagjNX1ptyKTAZOdQZ0wdPiQdlKurPqFCJEYu9nKof0lI9b" +
                            "GBUYJWrogY8McAkWTNqtQgiL2OgKc3s2MqkqAtPtEmf_Sx-xuwGFsG6ui9LANAJ_mgBmqvo" +
                            "jVAtQoK0sEusIa-8bJQZEuo2T8eh1tEjXXExt25jMN4tsUcfeVZSQMsHyHNpEWwF-QWMzp-" +
                            "RZuZDt09mt3vLJu26N7ZupUDZSxeYlwmJJUVVH3yDEB7G3-n_IycCRTgMDPuA4gdRBcKPu3" +
                            "-tJi7MsHxAw6tam-2lsKoDfmBHqlZhf5MI4wY1B8BWVOZgYRtJkfR6NKF66uUHq-Q1Ekcsy" +
                            "VGA6F1-yA1YYxDlqx7GpKZUKwYylxw=w353-h627-no?authuser=0"
                }
                "Jennifer Alejandra" -> {
                    urlImage = "https://lh3.googleusercontent.com/jrmylISycTA6Kvwj7pbZOiMQtINtsG-BXk" +
                            "wErbAPZXJdvc5pNm5h_HEUoahAf03eTm-YtAF9kFnGI38WuSebtE618B3TOEefuoH5V6hO0" +
                            "L9_R6-GzAvnQ5RR2AzYSJKI7JRiaZgZnvHiy68RkoWTuXrwFD8LI-IjQxQljkx77xe0j-Z9" +
                            "mt7i_fzXDcLHAoMbvcr54Om-_62wU7WwC6XPn5RgZ5m7ila24_ehCC_q1OTrb4fdFpkjmIr" +
                            "FMZ96sYkLgk9LUOgXBKAwBefu4eQeY0TxyHkVtoAZ0FzHaUvDoDFySTC49LFjvPEmURR_Xj" +
                            "lixB_1_zUlQxlnP8w84wyamF4KCcPeHp_pjqHz-lVA4WxfjOXCDzHSIgSHcqLG1dhioprGC" +
                            "AlWWMYpeVg5AsC9G4TOvJPtGMu3GHlp4ZVp8MEuw8gfJ1X49Y8y0D5Mk2FkwjpuBSLOfhNJ" +
                            "T5IdbHMc4WZ8vOiIguyzdUjM99wnXbHZ7nfAY_o7HBA_XGtaQpWEpmx3fEA_51bAqL7THHQ" +
                            "QeiuJa27doTXJ1A45eoNNj5NcwDD4s22TkzvWCsUZgwFkQ7L5wUGpT07GlWrIeP8b2ijsP_" +
                            "cM_HVLtp_q-mE22svdgIPyJl6cVDxEA8itciRWqEhtMREpzHHa5Mi9ZO1ahvN0S_SEz5m1K" +
                            "r5aTaGkr1pMsjIPub_emUUGWb9_=w640-h480-no?authuser=0"
                }
                "Miguel Antonio" -> {
                    urlImage = "https://lh3.googleusercontent.com/J-Mo2F4qVMQN9GNlx28VqHCL3xEFcwG5he5" +
                            "dHlmhyTGo_OsSz_1v1bDSLufSFTlhdqQwypk-yF2kGJ1sREOo8rgIH9MiSJMhudYb-MboIjU" +
                            "9srNoZ3HO0Nggjgdncx0hxA00siKm9MOQTk8e_9EWhFZ1b4p329m8m2tvMhqTgFvRTHTvxXg" +
                            "Pt0ETh4RlxJ9Ui4zdBkWIeLYLOblu5Ic76ATmVWzWn0yHLEwAHjkng9F5xulfNXhKfhC3xdu" +
                            "rnnrQtZR2L83c1a99e18rx8luvC4CsVjOkrHGMQPb-aRO_OC-Q_mElfVkAmUgkaeCnGu1cMM" +
                            "TkIcLNd5z0FfDlEg8mOKjFbJ5A8YU3NXVuR0EGegsIXk0NK5gJv6WRObf6UpcgHcMfpwlTt7" +
                            "CaEclTHsG0jySPsz5iLDIYrNhmyvhiVtIKRKNlZX11ahG82W0wq5eCAtdiSRVRSY4DV0Hom2" +
                            "DyazLSbgLcB6PNnaaRJ3DoPtiKMWAc_x_wd2y7vXCFzHsgeExxWL33NWUdDY8DZqVOEs_ctl" +
                            "OnuR4VYcRpXTep37Beit1IkGZ7VXGdC_B4gL7UwDNoT7RRd_n7NTw90McADthecds0zIK8NK" +
                            "d9IiL42fMNA1RyTvN7SbFfgO0jZBp363FCSpKtQ_5YHQ9ALCp5EnvEb5l5CE3AhYZmkU_nIp" +
                            "ZsyiYMBH0NpgBtJEzdPM=w471-h627-no?authuser=0"
                }
            }
            Glide.with(binding.ivMembers).load(urlImage).circleCrop()
                .into(binding.ivMembers)
        }

        override fun onClick(v: View?) {
            selectedFamily.value = listFamily[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        return FamilyViewHolder(ItemFamilyBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        val lista = listFamily[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listFamily.size
}