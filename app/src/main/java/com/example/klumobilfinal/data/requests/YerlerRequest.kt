package com.example.klumobilfinal.data.requests

import com.google.gson.annotations.SerializedName

data class YerlerRequest (
    @SerializedName("kateid")
    var email: String
)