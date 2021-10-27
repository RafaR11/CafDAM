package com.example.cafdam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.cafdam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var password = "1234"
    var correu = "alumne"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonEntrar.setOnClickListener {
            if (binding.editTextTextEmail.text.toString() == correu && binding.editTextTextPassword.text.toString() == password){
                var intent1 = Intent(applicationContext, MenuActivity::class.java)
                startActivity(intent1)
            } else {
                Toast.makeText(applicationContext, "Login incorrecto", Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonRegistrar.setOnClickListener{
            var intent2 = Intent(applicationContext, loginActivity::class.java)
            startActivity(intent2);
        }
    }
}