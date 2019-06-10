package com.example.kappc

import android.app.Application
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    var globales = MyApplication()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mAuth = FirebaseAuth.getInstance()

        btnAccess.setOnClickListener( View.OnClickListener { doEntrar() })

        doEntrar();
    }

    private fun doEntrar() {
        Log.i("KAPPC", "Conectando")
        val email = "userkotlin@jeefb.com"
        val pswd = "123456"



        // para permitir el acceso de un Usuario con Contraseña
        // debe crearce mediante el metodo proporcionado por Firebase
//        val n = mAuth.createUserWithEmailAndPassword("userkotlin@jeefb.com", "123456")
//            .addOnCompleteListener( { task ->
//                if (task.isSuccessful){
//                    Log.i("KAPPC", "Con Exito")
//                } else {
//                    Log.i("KAPPC", "Fallido")
//                }
//            }
//        )

//        Log.i("KAPPC", "Creacion: "+n.isSuccessful)

        val m = mAuth.signInWithEmailAndPassword(email, pswd)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val result = task.result
                    val emailVerified = result?.user?.isEmailVerified
                    val user = result?.user?.metadata.toString()
                    val providers = result?.user?.providers.toString()
                    globales.globalVarUsuario = mAuth.currentUser!!
                    Log.i("KAPPC", "::: Resultado Existoso " + user + " --" + providers )
                    startActivity(Intent(this, bdd::class.java))
                } else {
                    Log.i("KAPPC", "Resultado Fallido ")
                }
            }
    }
}

class MyApplication : Application() {
    var globalVarUsuario = FirebaseAuth.getInstance().currentUser
}
