package com.OpenInnovation.ecs.Activity

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.OpenInnovation.ecs.R
import com.OpenInnovation.ecs.back.EmployeAdapter
import com.OpenInnovation.ecs.back.model.Employe
import kotlinx.android.synthetic.main.activity_main_second2.*
import kotlinx.android.synthetic.main.employe_cell.view.*

class SecondMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second2)

        ui_recyclerView.layoutManager = LinearLayoutManager(this)
        ui_recyclerView.adapter = EmployeAdapter(1,this)

        ui_NbPersRestante.text =  (ui_recyclerView.adapter as EmployeAdapter).EmployeArray.filter { employe -> !employe.IsSecure }.size.toString()

        ui_btnAnnuler.setOnClickListener { v -> ui_panelConfirmation.isVisible = false  }
        ui_btnConfirmer.setOnClickListener {
                v -> run {
            ui_panelConfirmation.isVisible = false
            viewSelectionne.isVisible = false
            refreshNbPersonnes()
        }
      }
    }
    lateinit var viewSelectionne : View

    fun refreshNbPersonnes(){
        //TODO a terme faire avec un nouveau get mais actuellement juste -1 au nb
        //TODO car actuellement update non fonctionnel
        ui_NbPersRestante.text = (ui_NbPersRestante.text.toString().toInt() -1).toString()
    }
}
