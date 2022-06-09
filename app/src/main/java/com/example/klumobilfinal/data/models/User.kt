package com.example.klumobilfinal.data.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("ID")
    var id: String,

    @SerializedName("AD")
    var firstName: String,

    @SerializedName("SOYAD")
    var lastName: String,

    @SerializedName("MAIL")
    var email: String
)