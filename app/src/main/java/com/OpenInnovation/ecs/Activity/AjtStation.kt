package com.OpenInnovation.ecs.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.OpenInnovation.ecs.R
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
