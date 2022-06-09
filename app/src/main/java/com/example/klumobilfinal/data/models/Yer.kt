package com.example.klumobilfinal.data.models

import com.google.gson.annotations.SerializedName

data class Yer (
    @SerializedName("ID")
    var id: Int,

    @SerializedName("AD")
    var ad: String,

    @SerializedName("ACIKLAMA")
    var aciklama: String,

    @SerializedName("SAAT")
    var saat: String,

    @SerializedName("ULASIM")
    var ulasim: String,

    @SerializedName("KAT_ID")
    var katid: String
)