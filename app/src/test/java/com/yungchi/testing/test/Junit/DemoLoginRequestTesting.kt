package com.yungchi.testing.test.Junit

import com.yungchi.testing.model.DataModel
import com.yungchi.testing.model.ILoginResponse
import com.yungchi.testing.model.LoginRequest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DemoLoginRequestTesting {

    @InjectMocks
    lateinit var mLoginRequest: LoginRequest

    @Mock
    lateinit var mDataModel: DataModel

    // TODO checking function have been called
    @Mock
    lateinit var iILoginResponse: ILoginResponse

    @Before
    fun setUp() {}

    @Test
    fun whereSendRequestAndWaitingForResponseSuccessCallBack() {
        `when`(mDataModel.returnCode).thenReturn(0)
        mLoginRequest.sendRequest()
        // API Delay 3000 millis to simulate response
        Thread.sleep(4000)
        Mockito.verify(iILoginResponse,Mockito.times(1)).onSuccess()
    }

    @Test
    fun whereSendRequestAndWaitingForResponseFailCallBack() {
        `when`(mDataModel.returnCode).thenReturn(1)
        mLoginRequest.sendRequest()
        // API Delay 3000 millis to simulate response
        Thread.sleep(4000)
        Mockito.verify(iILoginResponse,Mockito.times(1)).onFail()
    }
}