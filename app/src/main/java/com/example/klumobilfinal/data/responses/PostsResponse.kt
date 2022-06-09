package com.example.klumobilfinal.data.responses

import com.google.gson.annotations.SerializedName
import com.example.klumobilfinal.data.models.Post

data class PostsResponse (
    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var posts: ArrayList<Post>
)