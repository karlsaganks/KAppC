package com.example.kappc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        btnAccess.setOnClickListener( View.OnClickListener { doEntrar() })
    }

    private fun doEntrar() {
        Log.i("KAPPC", "Conectando")
        val email = "userkotling@jeefb.com"
        val pswd = "123456"

//        val n = mAuth.createUserWithEmailAndPassword("demo@jeefb.com", "123456")
//            .addOnCompleteListener( { task ->
//                if (task.isSuccessful){
//                    Log.i("KAPPC", "Con Exito")
//                } else {
//                    Log.i("KAPPC", "Fallido")
//                }
//            }
//        )

      //  Log.i("KAPPC", "Creacion: "+n.isSuccessful)

        val m = mAuth.signInWithEmailAndPassword(email, pswd)
            .addOnCompleteListener { task ->
                Log.i("KAPPC", "Resultado " + task.toString())

                if (task.isSuccessful) {
                    val result = task.result
                    val emailVerified = result?.user?.isEmailVerified
                    val user = result?.user?.toString()
                    val providers = result?.user?.providers.toString()
                    Log.i("KAPPC", "Resultado Existoso ")
                } else {
                    Log.i("KAPPC", "Resultado Fallido ")
                }
            }
        Log.i("KAAPC", "Es: "+ m.isSuccessful)
    }
}
