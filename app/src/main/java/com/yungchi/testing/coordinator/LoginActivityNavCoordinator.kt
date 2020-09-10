package com.yungchi.testing.coordinator

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.yungchi.testing.common.BaseCoordinator
import com.yungchi.testing.common.BaseNavCoordinator
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import kotlin.reflect.KClass

/**
 * Created by i9400514 on 2020/09/03.
 */
class LoginActivityNavCoordinator(context: Context, fragment: Fragment) :
    BaseNavCoordinator(context = context, fragment = fragment) {

    init {
        viewModel = LoginActivityViewModel()
        //        val factoryCalenderViewModelFactory = MainActivityViewModelFactory(context)
//        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)
//            .get(MainActivityViewModel::class.java)
    }

}