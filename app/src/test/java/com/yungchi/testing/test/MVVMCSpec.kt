package com.yungchi.testing.test

import androidx.lifecycle.Observer
import com.yungchi.testing.viewmodel.LoginActivityViewModel
import junit.framework.TestCase.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object MVVMCSpec : Spek({
    describe("MVVMC sample") {
//        val context: Context = ApplicationProvider.getApplicationContext()
//        val loginActivityCoordinator: LoginActivityCoordinator<LoginActivity> =
//            LoginActivityCoordinator(context, LoginActivity::class)


        context("unit test MVVMC") {
            val viewModel = LoginActivityViewModel()
            beforeEachTest {
            }

            it("should have a size > 0") {
                //TODO observeForever有問題
                viewModel.mEventTypeList.observeForever(Observer { data ->
                    assertEquals("", data[0])
                })

                viewModel.initEventTypeList()
            }

        }
    }
})