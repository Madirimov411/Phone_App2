package com.uzb7.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uzb7.phoneapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            bPhones.setOnClickListener {
                val i=Intent(this@MainActivity, PhonesActivity::class.java)
                startActivity(i)
            }
            bAddPhone.setOnClickListener {
                val i=Intent(this@MainActivity, AddPhoneActivity::class.java)
                startActivity(i)
            }
        }
    }
}