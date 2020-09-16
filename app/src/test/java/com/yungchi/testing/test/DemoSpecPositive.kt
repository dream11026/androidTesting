package com.yungchi.testing.test

import com.yungchi.testing.model.DataModel
import com.yungchi.testing.model.ILoginResponse
import com.yungchi.testing.model.LoginRequest
import com.yungchi.testing.test.DemoSpecPositive.iDemoViewData
import com.yungchi.testing.test.DemoSpecPositive.iILoginResponse
import com.yungchi.testing.test.DemoSpecPositive.mDataModel
import com.yungchi.testing.test.DemoSpecPositive.mDemoViewModel
import com.yungchi.testing.test.DemoSpecPositive.mLoginRequest
import com.yungchi.testing.viewmodel.DemoViewModel
import com.yungchi.testing.viewmodel.IDemoViewData
import org.junit.Assert
import org.mockito.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/**
 * Created by i9400514 on 2020/07/22.
 */
object DemoSpecPositive : Spek({
    describe("Login Testing") {
        // mock creation
        context("Positive Testing") {

            beforeEachTest {
                Mockito.`when`(mDataModel.userID).thenReturn("A12345678A")
                Mockito.`when`(mDataModel.userName).thenReturn("我是誰")
                Mockito.`when`(mDataModel.returnCode).thenReturn(0)
            }

            it("(Positive)where doLogin And waiting For update userInfo CallBack") {
                mDemoViewModel.doLogin()
                // API Delay 3000 millis to simulate response
                Thread.sleep(3000)
                Mockito.verify(iDemoViewData, Mockito.times(1))
                    .updateUserInfo(Mockito.anyString(), Mockito.anyString())
            }

            it("(Positive)where SendRequest And Waiting For Response Success CallBack") {
                mLoginRequest.sendRequest()
                // API Delay 3000 millis to simulate response
                Thread.sleep(3000)
                Mockito.verify(iILoginResponse, Mockito.times(1)).onSuccess()
            }

            it("(Positive)where SendRequest And Waiting For Response Fail CallBack") {
                Mockito.`when`(mDataModel.returnCode).thenReturn(1)
                mLoginRequest.sendRequest()
                // API Delay 3000 millis to simulate response
                Thread.sleep(3000)
                Mockito.verify(iILoginResponse, Mockito.times(1)).onFail()
            }
        }
    }
}) {
    @InjectMocks
    lateinit var mDemoViewModel: DemoViewModel

    // TODO override call function
    @Spy
    var iDemoViewData: IDemoViewData = object : IDemoViewData {
        override fun updateUserInfo(userName: String, userID: String) {
            Assert.assertNotNull(userID)
            Assert.assertNotNull(userName)
            Assert.assertTrue(userID.contains("*"))
        }
    }

    @InjectMocks
    lateinit var mLoginRequest: LoginRequest

    @Mock
    lateinit var mDataModel: DataModel

    // TODO checking function have been called
    @Mock
    lateinit var iILoginResponse: ILoginResponse

    init {
        MockitoAnnotations.initMocks(this)
    }

}


