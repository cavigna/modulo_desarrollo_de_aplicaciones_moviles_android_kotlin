package com.example.inmobiliariagalactica.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class Terreno(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: String = "",
    @SerializedName("img_src")
    var imgSrc: String = "",
    @SerializedName("price")
    var price: Int = 0,
    @SerializedName("type")
    var type: String = ""
)