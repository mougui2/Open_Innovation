package com.example.openinnovationfdc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.openinnovation.ConnexionAdmin
import com.example.openinnovation.SecondMain
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
