package com.OpenInnovation.ecs.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.OpenInnovation.ecs.R
import com.OpenInnovation.ecs.back.model.Data.Companion.verifyConnexion
import kotlinx.android.synthetic.main.activity_connexion_admin.*

class ConnexionAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion_admin)


        btnValideConnexion.setOnClickListener{

            var canConnect = verifyConnexion(ui_email.text.toString(),ui_mdp.text.toString())
            if(canConnect){
                val intent = Intent(this, AjtStation::class.java)
                startActivity(intent)
            }else{
                ui_error.isVisible = true
            }

        }
    }
}
