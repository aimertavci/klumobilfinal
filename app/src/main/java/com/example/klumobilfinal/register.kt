package com.example.klumobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.klumobilfinal.data.ApiClient
import com.example.klumobilfinal.data.requests.LoginRequest
import com.example.klumobilfinal.data.requests.RegisterRequest
import com.example.klumobilfinal.data.responses.LoginResponse
import com.example.klumobilfinal.data.responses.RegisterResponse
import com.example.klumobilfinal.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class register : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun click_btn_register(view: View){
        var ad= findViewById(R.id.txt_register_ad) as EditText
        var soyads= findViewById(R.id.txt_register_soyad) as EditText
        var email= findViewById(R.id.txt_register_mail) as EditText
        var sifre= findViewById(R.id.txt_register_sifre) as EditText
        var sifre2= findViewById(R.id.txt_register_sifre2) as EditText

        if(ad.text.toString().trim().isEmpty() || soyads.text.toString().trim().isEmpty() || email.text.toString().trim().isEmpty() ||sifre.text.toString().trim().isEmpty() ||sifre2.text.toString().trim().isEmpty()   ){
            Toast.makeText(this,"Tüm Alanları Doldurunuz", Toast.LENGTH_LONG).show()
        }else{
           if(sifre.text.toString()==sifre2.text.toString()){
               apiClient = ApiClient()
               val context=this
               sessionManager = SessionManager(this)

               apiClient.getApiService(this).register(RegisterRequest(email = email.text.toString(), password = sifre.text.toString(),ad=ad.text.toString(),soyad=soyads.text.toString()))
                   .enqueue(object : Callback<RegisterResponse> {
                       override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                           // Error logging in
                       }
                       override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                           val loginResponse = response.body()
                           if (loginResponse?.statusCode == 200 && loginResponse.user != null) {
                               sessionManager.saveAuthToken(loginResponse.authToken)
                               val intent = Intent(context, MainActivity::class.java)
                               startActivity(intent)
                           } else if(loginResponse?.statusCode == 300) {
                               Toast.makeText(context,"Bu Mail Adresi İle Kayıt Yapılmış",Toast.LENGTH_LONG).show()
                           }

                       }
                   })

           }else{
               Toast.makeText(this,"Şifreniz Uyuşmuyor", Toast.LENGTH_LONG).show()
           }
        }
    }

}