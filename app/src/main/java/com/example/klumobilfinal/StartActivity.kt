package com.example.klumobilfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }
    fun click_login(view: View){
        val intent = Intent(this, login::class.java)
        startActivity(intent)
    }
    fun click_register(view: View){
        val intent = Intent(this, register::class.java)
        startActivity(intent)
    }
}