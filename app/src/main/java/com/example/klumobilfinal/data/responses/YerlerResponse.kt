package com.example.klumobilfinal.data.responses

import com.example.klumobilfinal.data.models.Yer
import com.google.gson.annotations.SerializedName

data class YerlerResponse (
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var posts: ArrayList<Yer>
)