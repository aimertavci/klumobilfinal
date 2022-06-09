package com.example.klumobilfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klumobilfinal.databinding.ActivityKategorilisteBinding
import com.example.klumobilfinal.data.ApiClient
import com.example.klumobilfinal.data.models.Post
import  com.example.klumobilfinal.data.responses.PostsResponse
import  com.example.klumobilfinal.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class kategoriliste : AppCompatActivity() {
    private lateinit var binding: ActivityKategorilisteBinding
    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager
    private lateinit var kategorilist : ArrayList<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        val context=this
        super.onCreate(savedInstanceState)
        binding = ActivityKategorilisteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService(this).fetchPosts()
            .enqueue(object : Callback<PostsResponse> {
                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(call: Call<PostsResponse>, response: Response<PostsResponse>) {
                    // Handle function to display posts
                    val kategoriler = response.body()
                    if (kategoriler != null) {
                        kategorilist=kategoriler.posts
                        binding.recyclerView.layoutManager = LinearLayoutManager(context)
                        val adapter = kategori_adapter(kategorilist)
                        binding.recyclerView.adapter = adapter
                        Log.d("myTag", kategorilist.toString())

                    }
                }
            })

        //RecyclerView


    }
}