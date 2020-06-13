package com.OpenInnovation.ecs.back.model

import java.sql.*
import java.util.Date
import kotlin.concurrent.thread

class Data{

    companion object{
        private fun getRowCount(resultSet: ResultSet?): Int {
            if (resultSet == null) {
                return 0
            }
            try {
                resultSet.last()
                return resultSet.row
            } catch (exp: SQLException) {
                exp.printStackTrace()
            } finally {
                try {
                    resultSet.beforeFirst()
                } catch (exp: SQLException) {
                    exp.printStackTrace()
                }
            }
            return 0
        }

        private fun connectToDataBase(): Connection {
            var connection =DriverManager.getConnection(
                "jdbc:mariadb://51.254.38.176:3305/OpenInnovation",
                "openinnovation_user",
                "380487057734c4882e560b7c3840edbf"
            )
            return connection
        }

        fun execRequete(rqt: String): ResultSet? {
            var errorOccured = false
            var result : ResultSet? = null
            var task =   thread(start = true ) {
                var connect = connectToDataBase()
                try {
                    val stmt = connect.createStatement()
                    result = stmt.executeQuery(rqt)

                }catch (ex:Exception){
                    errorOccured = true
                   printError(ex.message)
                }finally {
                    connect.close()
                    return@thread
                }

            }
            task.join()
            return result
        }

        private fun printError(message: String?) {
            println("---------------------------------------------------------------------------------------")
            println("----------------------------------------ERROR--------------------------------------------")
            println("---------------------------------------------------------------------------------------")
            println(message)
        }

        fun getAllEmployeByIdEntreprise(id:Int) : List<Employe>{
            var result = execRequete("select * from employe where employe.idEntreprise = ${id}")
            var empList = mutableListOf<Employe>()
            if(result != null){
                while (result.next()) {
                    empList.add(Employe(result.getInt("id"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getBoolean("isSecure"),
                        getEntrepriseById(result.getInt("idEntreprise"))))
                }
            }
            return empList
        }

        fun getEntrepriseById(id:Int): Entreprise {
            var result = execRequete("Select * from entreprise where id =${id}")
            if(result != null){
                result.next()
                return Entreprise(result.getInt("id"),
                    result.getString("libelle")
                    ,result.getInt("numeroRue"),
                    result.getString("nomRue"),
                    result.getString("ville"),
                    result.getInt("codePostal"))
            }
           return Entreprise(0,"erreur",0,"erreur","erreur",0)
        }

        fun getAllStation():List<Lieux>{
            var result = execRequete("select * from lieux where isStationRecensement = 1")
            var stationList = mutableListOf<Lieux>()

            if(result != null) {
                while (result.next()) {
                    stationList.add(
                        Lieux(
                            result.getInt("id"),
                            result.getString("libelle"),
                            result.getString("localisation"),
                            result.getBoolean("isStationRecensement"),
                            getEntrepriseById(result.getInt("idEntreprise"))
                        )
                    )
                }
            }
            return stationList
        }

        fun getLastPositionByEmployeId(id:Int):DernierePosition{
            var result = execRequete("SELECT * from dernierePosition where idemploye = ${id}")
            if(result != null) {
                result.next()
                return DernierePosition(
                    result.getInt("idEmploye"),
                    getLieuxById(result.getInt("idLieux"))
                    , result.getDate("date")
                )
            }
            return DernierePosition(0, Lieux(0,"erreur","erreur",false,Entreprise(0,"erreur",0,"erreur","erreur",0)), Date(0))
        }

        fun getLieuxById(id:Int):Lieux{
            var result = execRequete("SELECT * from lieux where id = ${id}")
            if(result != null) {
                result.next()
                return Lieux(
                    result.getInt("id"),
                    result.getString("libelle"),
                    result.getString("localisation"),
                    result.getBoolean("isStationRecensement"),
                    getEntrepriseById(result.getInt("idEntreprise"))
                )
            }
            return Lieux(0,"erreur","erreur",false,Entreprise(0,"erreur",0,"erreur","erreur",0))
        }

        fun setEmployeSecureByEmployId(id:Int):Boolean{
            try{
                var result = execRequete("UPDATE employe SET isSecure=1 WHERE id=${id}")
                return true
            }
            catch (ex : Exception){
                printError(ex.message)
                return false
            }
        }

        fun verifyConnexion(email:String,mdp:String):Boolean{
            if(email != "" && mdp != "" ){
                var result = execRequete("SELECT * from connexion where email = '${email}' and  mdp = '${mdp}'")
                if(result != null){
                    return result.next()
                }
            }
            return false

        }
    }
}