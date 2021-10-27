package com.example.cafdam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.cafdam.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.buttonRegistrar.setOnClickListener{
            var intentVolver = Intent(applicationContext, MainActivity::class.java)
            startActivity(intentVolver);
        }
    }
}