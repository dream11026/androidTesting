package com.yungchi.testing.coordinator

import android.app.Activity
import android.content.Context
import com.yungchi.testing.common.BaseCoordinator
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import kotlin.reflect.KClass

/**
 * Created by i9400514 on 2020/09/03.
 */
class LoginActivityCoordinator<ACT : Activity>(context: Context, targetClass: KClass<ACT>) :
    BaseCoordinator<ACT>(context = context) {

    init {
        viewModel = LoginActivityViewModel()
        super.targetActivity = targetClass
        //        val factoryCalenderViewModelFactory = MainActivityViewModelFactory(context)
//        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)
//            .get(MainActivityViewModel::class.java)
    }

}