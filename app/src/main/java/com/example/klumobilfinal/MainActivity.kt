package com.example.klumobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun click_cikis(view: View){
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
    fun click_bilgi(view: View){
        val intent = Intent(this, bilgilerim::class.java)
        startActivity(intent)
    }
    fun click_main_kategori(view: View){
        val intent = Intent(this, kategoriliste::class.java)
        startActivity(intent)
    }


}