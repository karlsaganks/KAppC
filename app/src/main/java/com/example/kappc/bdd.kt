package com.example.kappc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.example.kappc.Dao.EmpresaDao
import com.example.kappc.beans.Empresa
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.android.synthetic.main.activity_bdd.*
import kotlinx.coroutines.*


class bdd : AppCompatActivity() {

    //lateinit var fs: FirebaseFirestore

    var empresaDao = EmpresaDao()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bdd)

        var ee = Empresa()

//        fs = FirebaseFirestore.getInstance()
//
//        var globales = MyApplication();
//        if (globales.globalVarUsuario != null){
//            Log.i("KAPPC", "ES: " +  globales.globalVarUsuario?.uid)
//        }

        runBlocking {

                 ee = empresaDao.getEmpresaId(1)

//        fs.collection("empresa")
//            .get()
//            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
//                if (task.isSuccessful) {
//                    for (document in task.result!!) {
//
//                        Log.i("KAPPC", document.id + " => " + document.data)
//                        ee = Empresa(document.data as HashMap<String, Any>)
//                        txtCif.text = document.data.getValue("cif").toString()
//                        txtNom.text = document.data.getValue("nombre").toString()
//                        txtRes.text = document.data.getValue("responsable").toString()
//                        txtPwd.text = document.data.getValue("email").toString()
//                        Log.i("KAPPC", "Clase: "+ ee)
//                    }
//                } else {
//                    Log.i("KAPPC", "Error getting documents.", task.exception)
//                }
//            })

                Log.i("KAPPC", "P: " + ee)
            }
    }

    override fun onStart() {
        super.onStart()
       // Log.i("KAPPC", "OnStart: " + ee)
    }
}
