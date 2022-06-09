package com.example.klumobilfinal.data.models

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("ID")
    var id: Int,

    @SerializedName("KAT_AD")
    var title: String
)