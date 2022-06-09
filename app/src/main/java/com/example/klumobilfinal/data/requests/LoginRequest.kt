package com.example.klumobilfinal.data.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("mail")
    var email: String,

    @SerializedName("pass")
    var password: String
)