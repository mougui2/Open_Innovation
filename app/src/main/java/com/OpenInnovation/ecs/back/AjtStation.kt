package com.example.openinnovation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ajt_station.*

class AjtStation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajt_station)

        btnConfirmer.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
