package com.uzb7.phoneapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uzb7.phoneapp.model.Phone

@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhone(phone: Phone)

    @Query("SELECT * FROM phone")
    fun getPhone():List<Phone>

    @Query("SELECT * FROM phone WHERE id=:id")
    fun getPhoneId(id:Long):Phone
}