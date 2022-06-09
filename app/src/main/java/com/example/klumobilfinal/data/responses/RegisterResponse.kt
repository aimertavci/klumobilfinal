package com.example.klumobilfinal.data.responses

import com.google.gson.annotations.SerializedName
import com.example.klumobilfinal.data.models.User

data class RegisterResponse (
    @SerializedName("status_code")
    var statusCode: Int,

    @SerializedName("exp")
    var exp: String,

    @SerializedName("iat")
    var iat: String,

    @SerializedName("success")
    var success: String,

    @SerializedName("jwt")
    var authToken: String,

    @SerializedName("message")
    var message: String,

    @SerializedName("user")
    var user: User?
)