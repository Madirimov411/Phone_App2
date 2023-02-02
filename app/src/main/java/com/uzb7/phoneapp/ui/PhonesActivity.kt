package com.uzb7.phoneapp.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.uzb7.phoneapp.adapter.PhoneAdapter
import com.uzb7.phoneapp.databinding.ActivityPhonesBinding
import com.uzb7.phoneapp.model.Phone
import com.uzb7.phoneapp.repository.PhoneRepository

class PhonesActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhonesBinding
    lateinit var repository: PhoneRepository
    lateinit var phones:ArrayList<Phone>
    lateinit var adapter: PhoneAdapter
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
            adapter=PhoneAdapter(phones)
            rvPhones.adapter=adapter
            rvPhones.layoutManager=GridLayoutManager(this@PhonesActivity,1)
            adapter.send={
                val intent=Intent(this@PhonesActivity,PhoneAboutActivity::class.java)
                intent.putExtra("phones",it)
                startActivity(intent)
            }
            adapter.delete={
                showConfirmDialog(it)
            }

        }
    }

    private fun showConfirmDialog(phone: Phone) {
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Telefon ma'lumotini o'chirish")
        alertDialog.setMessage("Ishonchingiz komilmi?")
        alertDialog.setPositiveButton("Ha") { dialog, which ->
            repository.deletePhone(phone)
            phones=repository.getPhone() as ArrayList<Phone>
            adapter.submitList(phones)
            dialog.cancel()

        }
        alertDialog.setNegativeButton("Yo'q") {dialog, which ->
            dialog?.cancel()
        }
        alertDialog.show()

    }

    override fun onBackPressed() {
        finish()
    }
}
