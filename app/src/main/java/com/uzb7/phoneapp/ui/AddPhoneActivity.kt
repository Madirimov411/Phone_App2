package com.uzb7.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.uzb7.phoneapp.databinding.ActivityAddPhoneBinding
import com.uzb7.phoneapp.model.Phone
import com.uzb7.phoneapp.repository.PhoneRepository

class AddPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddPhoneBinding
    lateinit var repository: PhoneRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddPhoneBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        repository = PhoneRepository(application)
        binding.apply {
            bAdd.setOnClickListener {
                if (etAbout.text.toString().isNotEmpty() && etName.text.toString().isNotEmpty()) {
                    val phone= Phone(phoneName = etName.toString(), details = etAbout.toString())
                    repository.savePhone(phone)
                    finish()
                }
                else{
                    Toast.makeText(this@AddPhoneActivity, "Ma'lumotlarni to'liq kiriting", Toast.LENGTH_SHORT).show()
                }
            }
            ivBack.setOnClickListener {
                finish()
            }
        }

    }

    override fun onBackPressed() {
        finish()
    }
}