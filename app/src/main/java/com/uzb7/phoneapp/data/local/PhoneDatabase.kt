package com.uzb7.phoneapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uzb7.phoneapp.model.Phone

@Database([Phone::class], version = 1)
abstract class PhoneDatabase : RoomDatabase() {

    abstract fun getPhoneDao(): PhoneDao

    companion object {
        private var DB_INSTANCE: PhoneDatabase? = null
        fun getInstance(context: Context): PhoneDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDatabase::class.java,
                    "phone"
                ).allowMainThreadQueries().build()
            }
            return DB_INSTANCE!!
        }
    }
}