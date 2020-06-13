package com.OpenInnovation.ecs.back.model

class Employe {
    internal var Id:Int =0;
    internal var Nom:String ="Nom inconnu";
    internal var Prenom:String ="prenom inconnu";
    internal var IsSecure:Boolean = false;
    lateinit var Entreprise:Entreprise;

    constructor(Id: Int, Nom: String, Prenom: String, IsSecure: Boolean, Entreprise: Entreprise) {
        this.Id = Id
        this.Nom = Nom
        this.Prenom = Prenom
        this.IsSecure = IsSecure
        this.Entreprise = Entreprise
    }

    override fun toString(): String {
        return Nom.toUpperCase() + " "+Prenom
    }
}