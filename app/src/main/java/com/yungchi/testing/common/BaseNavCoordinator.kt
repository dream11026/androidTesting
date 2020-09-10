package com.yungchi.testing.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController

/**
 * Created by i9400514 on 2020/09/03.
 */
abstract class BaseNavCoordinator(val context: Context, fragment: Fragment)
//<Act, VM>
//constructor(
//    activity: Activity,
//    viewModel: ViewModel
//)
{
    private var navController: NavController = findNavController(fragment)

    //    lateinit var context: Context
    lateinit var viewModel: ViewModel

    //    lateinit var parent: BaseCoordinator
//    lateinit var chirldren: BaseCoordinator
//    lateinit var chirldren: Activity
//    lateinit var targetActivity: KClass<ACT>

//    lateinit var parent: BaseCoordinator<Act, VM>
//    lateinit var chirldren: BaseCoordinator<Act, VM>

    init {
//        val factoryCalenderViewModelFactory = MainActivityViewModelFactory(context)
//        viewModel = ViewModelProviders.of(this, factoryCalenderViewModelFactory)

//        inline fun <reified ACT> genericType() = object : TypeToken<VM>() {}.type
//        viewModel = ViewModelProviders.of(activity)
//            .get(object :TypeToken<VM>() {}.type.javaClass)
//        viewModel = (object :TypeToken<VM>() {}.type.javaClass)

    }

    fun navStart(fragment:Fragment) {
        findNavController(fragment)
        navController.navigateUp()
    }

    fun navStart() {
        navController.navigateUp()
    }

    //
//    fun start(activity: KClass<ACT>) {
//        val fragment: Fragment = LoginFragment()
//        val transaction: FragmentTransaction =
//            getSupportFragmentManager().beginTransaction()
//        transaction.add(
//            R.id.point_mission_container,
//            fragment,
//            com.cathay.main.point.PointMissionActivity.TAG_POINT_MISSION_FRAGMENT
//        )
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
//
//    fun start() {
//        start(targetActivity)
//    }
//
//    fun close() {
//        context.finish()
//    }

//    fun startActivity(activity: KClass<ACT>, result: Int? = null) {
//        val intent = Intent(context, activity.java)
//        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
//        context.startActivity(intent)
//    }
//
//    fun startActivity() {
//        startActivity(targetActivity)
//    }

//    fun close() {
//        context.finish()
//    }
}