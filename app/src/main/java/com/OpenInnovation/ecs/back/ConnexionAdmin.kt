package com.example.openinnovation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_connexion_admin.*

class ConnexionAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion_admin)


        btnValideConnexion.setOnClickListener{

            val intent = Intent(this, AjtStation::class.java)
            startActivity(intent)
        }
    }
}
