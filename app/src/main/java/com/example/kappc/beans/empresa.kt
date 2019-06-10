package com.example.kappc.beans

class Empresa {
    var id_empresa: Int = 0
    var cif: String? = null
    var nombre_empresa: String? = null
    var responsable: String? = null
    var email: String? = null

    constructor() {}

    constructor(cif: String, nombre_empresa: String, responsable: String, email: String) {
        this.cif = cif
        this.nombre_empresa = nombre_empresa
        this.responsable = responsable
        this.email = email
    }

    constructor(id_empresa: Int, cif: String, nombre_empresa: String, responsable: String, email: String) {
        this.id_empresa = id_empresa
        this.cif = cif
        this.nombre_empresa = nombre_empresa
        this.responsable = responsable
        this.email = email
    }

    constructor(datos: HashMap<String, Any>){
        this.cif = datos.getValue("cif").toString()
        this.id_empresa = (datos.getValue("id_empresa").toString()).toInt()
        this.nombre_empresa = datos.getValue("nombre").toString()
        this.responsable = datos.getValue("responsable").toString()
        this.email = datos.getValue("email").toString()

    }

    override fun toString(): String {
        return "Empresa{" +
                "id_empresa=" + id_empresa +
                ", cif='" + cif + '\''.toString() +
                ", nombre_empresa='" + nombre_empresa + '\''.toString() +
                ", responsable='" + responsable + '\''.toString() +
                ", email='" + email + '\''.toString() +
                '}'.toString()
    }
}