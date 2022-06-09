package com.example.klumobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.klumobilfinal.data.ApiClient
import com.example.klumobilfinal.data.requests.LoginRequest
import com.example.klumobilfinal.data.responses.LoginResponse
import com.example.klumobilfinal.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }
    fun click_btn_login(view: View){
        var email= findViewById(R.id.txt_mail) as EditText
        var sifre= findViewById(R.id.txt_sifre) as EditText
        if(email.text.toString().trim().isEmpty() ||sifre.text.toString().trim().isEmpty() ){
            Toast.makeText(this,"Tüm Alanları Doldurunuz",Toast.LENGTH_LONG).show()
        }else{
            apiClient = ApiClient()
            val context=this
            sessionManager = SessionManager(this)

            apiClient.getApiService(this).login(LoginRequest(email = email.text.toString(), password = sifre.text.toString()))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Error logging in
                    }
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        val loginResponse = response.body()
                        Log.d("myTag", loginResponse?.message.toString());
                        if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                            sessionManager.saveAuthToken(loginResponse.authToken)
                            val intent = Intent(context, MainActivity::class.java)
                            startActivity(intent)
                        } else if(loginResponse?.statusCode == 300) {
                            Toast.makeText(context,"Hatalı Kullanıcı Adı ve Şifre",Toast.LENGTH_LONG).show()
                        }

                    }
                })


        }

    }
}