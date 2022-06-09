package com.example.klumobilfinal.data.requests

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("mail")
    var email: String,

    @SerializedName("pass")
    var password: String,

    @SerializedName("ad")
    var ad: String,

    @SerializedName("soyad")
    var soyad: String
)