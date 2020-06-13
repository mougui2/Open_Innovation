package com.OpenInnovation.ecs.back.model

class Lieux {
    internal var Id:Int =0;
    internal var Libelle:String = "Libelle inconnu";
    internal var Localisation:String ="Localisation inconnue";
    internal var IsSationRecensement:Boolean = false;
    lateinit var Entreprise:Entreprise

    constructor(
        Id: Int,
        Libelle: String,
        Localisation: String,
        IsSationRecensement: Boolean,
        Entreprise: Entreprise
    ) {
        this.Id = Id
        this.Libelle = Libelle
        this.Localisation = Localisation
        this.IsSationRecensement = IsSationRecensement
        this.Entreprise = Entreprise
    }
}