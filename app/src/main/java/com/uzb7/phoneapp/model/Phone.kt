package com.uzb7.phoneapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "phone")
data class Phone(
    @PrimaryKey(autoGenerate = true)
    val id:Long?=null,
    val phoneName:String,
    val details: String
): Serializable
