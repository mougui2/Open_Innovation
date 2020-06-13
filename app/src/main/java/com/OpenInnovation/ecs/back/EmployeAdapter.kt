package com.OpenInnovation.ecs.back

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.OpenInnovation.ecs.Activity.SecondMain
import com.OpenInnovation.ecs.R.layout
import com.OpenInnovation.ecs.back.model.Data.Companion.getAllEmployeByIdEntreprise
import com.OpenInnovation.ecs.back.model.Data.Companion.getLastPositionByEmployeId
import com.OpenInnovation.ecs.back.model.Data.Companion.setEmployeSecureByEmployId
import com.OpenInnovation.ecs.back.model.Employe
import kotlinx.android.synthetic.main.activity_main_second2.*
import kotlinx.android.synthetic.main.activity_main_second2.view.*
import kotlinx.android.synthetic.main.employe_cell.view.*

class EmployeAdapter(idEntreprise:Int,secondMain: SecondMain) : RecyclerView.Adapter<EmployeViewHolder>(), EmployeViewHolder.OnClickAdapter {

    val EmployeArray : Array<Employe> = getAllEmployeByIdEntreprise(idEntreprise).toTypedArray();
    val secondMain = secondMain
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(layout.employe_cell, parent, false)
        return EmployeViewHolder(rootView, this)
    }

    override fun getItemCount(): Int {
       return  EmployeArray.size
    }

    override fun onBindViewHolder(holder: EmployeViewHolder, position: Int) {
        holder.prepareForShowEmploye(EmployeArray[position],getLastPositionByEmployeId(EmployeArray[position].Id))
    }

    override fun customOnClick(v: View, position: Int) {
       //TODO fix les update non fonctionnels
        // setEmployeSecureByEmployId((v as EmployeViewHolder).Employe.Id)
        secondMain.viewSelectionne = v
        secondMain.ui_panelConfirmation.isVisible = true
        secondMain.ui_confirmationNom.text = EmployeArray[position].toString()

        //v.ui_exitBtn.isVisible = false
        //secondMain.refreshNbPersonnes()
    }
}