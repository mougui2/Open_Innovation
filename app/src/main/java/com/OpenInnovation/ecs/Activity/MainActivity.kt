package com.OpenInnovation.ecs.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.OpenInnovation.ecs.R
import com.OpenInnovation.ecs.back.model.Data
import com.OpenInnovation.ecs.back.model.Lieux
import kotlinx.android.synthetic.main.activity_main.*
import java.util.function.Consumer


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stationList : List<Lieux> = Data.getAllStation()
        var stationListName : MutableList<String> = mutableListOf()
        for (station in stationList){
            stationListName.add(station.Libelle)
        }


        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,stationListName)

        ui_stationAutoComplete.setAdapter(adapter)


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
