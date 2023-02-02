package com.uzb7.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uzb7.phoneapp.databinding.ActivityPhoneAboutBinding
import com.uzb7.phoneapp.model.Phone

class PhoneAboutActivity : AppCompatActivity() {
    lateinit var binding:ActivityPhoneAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityPhoneAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {

            val phone=intent.getSerializableExtra("phones") as Phone
            tvPhoneAbout.text=phone.details
            tvName.text=phone.phoneName
            ivBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}