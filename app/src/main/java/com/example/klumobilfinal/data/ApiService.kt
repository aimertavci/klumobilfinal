package com.example.klumobilfinal.data

import com.example.klumobilfinal.data.requests.LoginRequest
import com.example.klumobilfinal.data.requests.RegisterRequest
import com.example.klumobilfinal.data.requests.YerlerRequest
import com.example.klumobilfinal.data.responses.LoginResponse
import com.example.klumobilfinal.data.responses.PostsResponse
import com.example.klumobilfinal.data.responses.RegisterResponse
import com.example.klumobilfinal.data.responses.YerlerResponse
import com.example.klumobilfinal.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET(Constants.YER_URL)
    fun fetchyer(): Call<YerlerResponse>

    @GET(Constants.POSTS_URL)
    fun fetchPosts(): Call<PostsResponse>

    @POST(Constants.REGISTER_URL)
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
}