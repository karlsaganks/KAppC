package com.example.kappc.Dao

import android.util.Log
import com.example.kappc.MyApplication
import com.example.kappc.beans.Empresa
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_bdd.*
import com.google.firebase.firestore.CollectionReference

import kotlinx.coroutines.*



class EmpresaDao:IEmpresa {

    lateinit var fs: FirebaseFirestore

    constructor(){
        fs = FirebaseFirestore.getInstance()

        var globales = MyApplication();
        if (globales.globalVarUsuario != null){
            Log.i("KAPPC", "ES: " +  globales.globalVarUsuario?.uid)
        }
    }

    override fun getEmpresaId(id_empresa: Int): Empresa {
        var ee = Empresa()

            fs.collection("empresa").whereEqualTo("id_empresa", id_empresa)
                .get()
                .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            ee = Empresa(document.data as HashMap<String, Any>)
                            Log.i("KAPPC", "EmpresaDao " + ee)
                        }
                    } else {
                        Log.i("KAPPC", "Error getting documents.", task.exception)
                    }
                })


        Log.i("KAPPC", "Es: "+ ee)
        return  ee
    }

//    override fun getEmpresas(): List<Empresa> {
//        return null
//    }
//
//    override fun primero(): Empresa {
//    }
//
//    override fun ultimo(): Empresa {
//    }
//
//    override fun nuevo(e: Empresa): Boolean {
//    }
//
//    override fun eliminar(id_empresa: Int): Boolean {
//    }
//
//    override fun actualizar(e: Empresa): Boolean {
//    }
}