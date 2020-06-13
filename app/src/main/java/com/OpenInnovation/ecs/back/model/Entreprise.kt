package com.OpenInnovation.ecs.back.model

class Entreprise {
    internal var Id:Int =0;
    internal var Libelle:String ="RS inconnue";
    internal var NumeroRue:Int =0;
    internal var NomRue:String ="nom de la rue inconnue";
    internal var Ville:String ="ville inconnue";
    internal var CodePostal:Int =0;

    constructor(
        Id: Int,
        Libelle: String,
        NumeroRue: Int,
        NomRue: String,
        Ville: String,
        CodePostal: Int
    ) {
        this.Id = Id
        this.Libelle = Libelle
        this.NumeroRue = NumeroRue
        this.NomRue = NomRue
        this.Ville = Ville
        this.CodePostal = CodePostal
    }
}