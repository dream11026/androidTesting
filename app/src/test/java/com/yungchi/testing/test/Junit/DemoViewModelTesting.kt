package com.yungchi.testing.test.Junit

import com.yungchi.testing.model.DataModel
import com.yungchi.testing.viewmodel.DemoViewModel
import com.yungchi.testing.viewmodel.IDemoViewData
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DemoViewModelTesting {
    @InjectMocks
    lateinit var mDemoViewModel: DemoViewModel

    @Mock
    lateinit var iDemoViewData: IDemoViewData

    @Mock
    lateinit var mDataModel: DataModel

    @Before
    fun setUp() {}

    @Test
    fun whereDoLoginAndWaitingForUpdateUserInfoCallBack() {
        `when`(mDataModel.returnCode).thenReturn(0)
        mDemoViewModel.doLogin()
        // API Delay 5000 millis to simulate response
        Thread.sleep(3000)
        Mockito.verify(iDemoViewData,Mockito.times(1)).updateUserInfo(Mockito.anyString(), Mockito.anyString())
    }
}