package com.example.openinnovation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


     btnConnexion.setOnClickListener{

     val intent = Intent(this, ConnexionAdmin::class.java)
         startActivity(intent)
     }

     btnValider.setOnClickListener{

         val intent = Intent(this, SecondMain::class.java)
            startActivity(intent)
     }

    }
}
