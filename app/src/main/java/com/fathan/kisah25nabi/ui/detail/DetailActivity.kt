package com.fathan.kisah25nabi.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fathan.kisah25nabi.R
import com.fathan.kisah25nabi.data.KisahResponse
import com.fathan.kisah25nabi.databinding.ActivityDetailBinding
import com.fathan.kisah25nabi.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA)
        data?.let {
            binding.apply {
                Glide.with(this@DetailActivity).load(data?.imageUrl).into(detailImage)
                detailNama.text = data.name
                detailTahun.text = data.thnKelahiran
                detailTempat.text = data.tmp
                detailUsia.text = data.usia
                detailDesk.text = data.description

            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}