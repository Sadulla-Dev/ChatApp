package com.intentsoft.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.intentsoft.chatapp.databinding.ActivityVerificationsBinding

class VerificationsActivity : AppCompatActivity() {
    var binding: ActivityVerificationsBinding? = null
    var auth :FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()

        if (auth!!.currentUser != null){
            val intent = Intent(this@VerificationsActivity,
                MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        supportActionBar?.hide()
        binding!!.editNumber.requestFocus()
        binding!!.continueBtn.setOnClickListener {
            val intent = Intent(this@VerificationsActivity,
                OTPActivity::class.java)
            intent.putExtra("phoneNumber",binding!!.editNumber.text.toString())
            startActivity(intent)
        }
    }
}