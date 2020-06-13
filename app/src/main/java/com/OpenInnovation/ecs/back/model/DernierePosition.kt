package com.OpenInnovation.ecs.back.model

import java.util.*

class DernierePosition {
    internal var IdEmploye:Int =0;
     lateinit var Lieux:Lieux ;
    lateinit var Date: Date;

    constructor(IdEmploye: Int, Lieux: Lieux, Date: Date) {
        this.IdEmploye = IdEmploye
        this.Lieux = Lieux
        this.Date = Date
    }
}