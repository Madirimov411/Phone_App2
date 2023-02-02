package com.uzb7.phoneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uzb7.phoneapp.R
import com.uzb7.phoneapp.model.Phone

class PhoneAdapter(val phones:ArrayList<Phone>):RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    var send:((Phone)->Unit)?=null

    class PhoneViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvPhoneName=view.findViewById<TextView>(R.id.tvPhoneName)
        val cvAbout=view.findViewById<CardView>(R.id.cvAbout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        return PhoneViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_phone_layout,parent,false))
    }

    override fun getItemCount() = phones.size

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone=phones[position]
        holder.apply {
            tvPhoneName.text=phone.phoneName
            cvAbout.setOnClickListener {
                send?.invoke(phone)
            }
        }

    }
}