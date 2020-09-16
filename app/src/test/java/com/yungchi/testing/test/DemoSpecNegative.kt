package com.yungchi.testing.test

import com.yungchi.testing.model.DataModel
import com.yungchi.testing.test.DemoSpecNegative.mDataModel1
import com.yungchi.testing.test.DemoSpecNegative.mDemoViewModel1
import com.yungchi.testing.viewmodel.DemoViewModel
import com.yungchi.testing.viewmodel.IDemoViewData
import org.junit.Assert
import org.mockito.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object DemoSpecNegative : Spek({
    describe("Login Testing") {
        // mock creation
        context("Positive/Negative Testing") {

            beforeEachTest {
                Mockito.`when`(mDataModel1.userID).thenReturn("")
                Mockito.`when`(mDataModel1.userName).thenReturn("誰阿")
                Mockito.`when`(mDataModel1.returnCode).thenReturn(0)
            }

            it("(Negative)where update userInfo CallBack userID is not correct") {
                mDemoViewModel1.doLogin()
                // API Delay 3000 millis to simulate response
                Thread.sleep(3000)
            }
        }
    }
}) {

    @InjectMocks
    lateinit var mDemoViewModel1: DemoViewModel

    // TODO override call function
    @Spy
    var iDemoViewData1: IDemoViewData = object : IDemoViewData {
        override fun updateUserInfo(userName: String, userID: String) {
            Assert.assertEquals("", userID)
        }
    }

    @Mock
    lateinit var mDataModel1: DataModel

    init {
        MockitoAnnotations.initMocks(this)
    }

}


