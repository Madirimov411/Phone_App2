package com.uzb7.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.uzb7.phoneapp.adapter.PhoneAdapter
import com.uzb7.phoneapp.databinding.ActivityPhonesBinding
import com.uzb7.phoneapp.model.Phone
import com.uzb7.phoneapp.repository.PhoneRepository

class PhonesActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhonesBinding
    lateinit var repository: PhoneRepository
    lateinit var phones:ArrayList<Phone>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityPhonesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        repository= PhoneRepository(application)
        phones=repository.getPhone() as ArrayList<Phone>
        binding.apply {
            ivBack.setOnClickListener {
                finish()
            }
            val adapter=PhoneAdapter(phones)
            rvPhones.adapter=adapter
            rvPhones.layoutManager=GridLayoutManager(this@PhonesActivity,1)
            adapter.send={
                val intent=Intent(this@PhonesActivity,PhoneAboutActivity::class.java)
                intent.putExtra("phones",it)
                startActivity(intent)
            }

        }
    }

    override fun onBackPressed() {
        finish()
    }
}
