package com.example.post3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.post3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()

            val gender = when (binding.rgGender.checkedRadioButtonId) {
                R.id.rbMale -> "Laki-laki"
                R.id.rbFemale -> "Perempuan"
                else -> ""
            }

            if (nama.isEmpty() || username.isEmpty() || email.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty() || gender.isEmpty()
            ) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("NAMA", nama)
            intent.putExtra("USERNAME", username)
            intent.putExtra("EMAIL", email)
            intent.putExtra("GENDER", gender)
            startActivity(intent)
        }
    }
}
