package com.example.klumobilfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.klumobilfinal.data.ApiClient
import com.example.klumobilfinal.data.models.Yer
import com.example.klumobilfinal.databinding.ActivityKategoriYerlerBinding
import com.example.klumobilfinal.utils.SessionManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klumobilfinal.data.requests.YerlerRequest
import com.example.klumobilfinal.data.responses.YerlerResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class kategori_yerler : AppCompatActivity() {
    private lateinit var binding: ActivityKategoriYerlerBinding
    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager
    private lateinit var kategorilist : ArrayList<Yer>

    override fun onCreate(savedInstanceState: Bundle?) {
        val context=this
        super.onCreate(savedInstanceState)
        binding = ActivityKategoriYerlerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val landmark = intent.getIntArrayExtra("landmark")
        Log.d("myTag", landmark.toString());

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService(this).fetchyer()
            .enqueue(object : Callback<YerlerResponse> {
                override fun onFailure(call: Call<YerlerResponse>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(call: Call<YerlerResponse>, response: Response<YerlerResponse>) {
                    // Handle function to display posts
                    val kategoriler = response.body()
                    if (kategoriler != null) {
                        kategorilist=kategoriler.posts
                        binding.recyclerView.layoutManager = LinearLayoutManager(context)
                        val adapter = yer_adapter(kategorilist)
                        binding.recyclerView.adapter = adapter
                    }
                }
            })

    }
}