package com.yungchi.testing.coordinator

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.yungchi.testing.R
import com.yungchi.testing.view.LoginFragment
import kotlinx.android.synthetic.main.activity_login.*

//import com.yungchi.testing.viewmodel.LoginActivityViewModelFactory

class LoginActivity : AppCompatActivity() {
    private val context: Context by lazy { this }

    lateinit var loginactivitycoordinator: LoginActivityCoordinator<LoginActivity>

    val act: Activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        loginactivitycoordinator = LoginActivityCoordinator(this, LoginActivity::class)

//        LoginActivityNavCoordinator(this, LoginFragment()).navStart()

//        Navigation.createNavigateOnClickListener(R.id.action_to_loginFragment)

//        val navController = findNavController(R.id.f_login_fragment).navigateUp()

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.cl_activity_container, LoginFragment())
//            .commit()
    }
}
