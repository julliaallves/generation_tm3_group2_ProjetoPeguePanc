package com.generation.projetopanc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.generation.projetopanc.databinding.ActivitySignOutBinding
import com.google.firebase.auth.FirebaseAuth

class SignOutActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySignOutBinding
    private lateinit var user: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()

        binding.buttonLogOut.setOnClickListener{
            user.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}