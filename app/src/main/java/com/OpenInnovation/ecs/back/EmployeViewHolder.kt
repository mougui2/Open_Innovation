package com.OpenInnovation.ecs.back

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.OpenInnovation.ecs.back.model.DernierePosition
import com.OpenInnovation.ecs.back.model.Employe
import kotlinx.android.synthetic.main.employe_cell.view.*
import java.text.SimpleDateFormat

class EmployeViewHolder(private val root: View,private  val adapter: OnClickAdapter) : RecyclerView.ViewHolder(root),View.OnClickListener {
    interface OnClickAdapter {
        fun customOnClick(v: View, position: Int)
    }

    lateinit var Employe:Employe
    lateinit var LastPosition:DernierePosition

    fun prepareForShowEmploye(employe:Employe,lastPos:DernierePosition) {
        this.Employe = employe
        LastPosition = lastPos

        root.ui_nomPrenomTexte.text = employe.toString()
        root.ui_endroitTexte.text = lastPos.Lieux.Libelle
        root.ui_heureTexte.text = SimpleDateFormat("HH:mm").format(lastPos.Date)
        root.ui_exitBtn.isVisible = !employe.IsSecure
        root.ui_exitBtn.setOnClickListener(this)
    }
   override fun onClick(v: View) {
        adapter.customOnClick(v, adapterPosition)
    }
}