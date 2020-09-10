package com.yungchi.testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findNavController(R.id.f_main_fragment).navigate(R.id.action_mainActivity_to_loginActivity)

//        LoginActivityCoordinator(applicationContext, LoginActivity::class).start()
//        val intent = Intent(applicationContext, LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
//        startActivity(intent)

    }
}
