package com.uzb7.phoneapp.repository

import android.app.Application
import com.uzb7.phoneapp.data.local.PhoneDao
import com.uzb7.phoneapp.data.local.PhoneDatabase
import com.uzb7.phoneapp.model.Phone

class PhoneRepository {

    lateinit var phoneDao: PhoneDao

    constructor(application: Application){
        val db=PhoneDatabase.getInstance(application)
        phoneDao=db.getPhoneDao()
    }

    fun savePhone(phone: Phone){
        phoneDao.savePhone(phone)
    }

    fun getPhone():List<Phone>{
        return phoneDao.getPhone()
    }

    fun getPhoneId(id:Long):Phone{
        return phoneDao.getPhoneId(id)
    }

}