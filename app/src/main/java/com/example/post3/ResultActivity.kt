package com.example.post3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.post3.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("NAMA")
        val username = intent.getStringExtra("USERNAME")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")
        val password = intent.getStringExtra("PASSWORD")
        val confirmPassword = intent.getStringExtra("CONFIRM_PASSWORD")

        binding.tvNama.text = "Full Name: $nama"
        binding.tvUsername.text = "Username: $username"
        binding.tvEmail.text = "Email: $email"
        binding.tvGender.text = "Gender: $gender"
        binding.tvPassword.text = "Password: $password"
        binding.tvConfirmPassword.text = "Confirm Password: $confirmPassword"

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
